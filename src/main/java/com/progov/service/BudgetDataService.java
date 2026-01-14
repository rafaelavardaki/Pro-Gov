package com.progov.service;

import com.progov.model.BudgetData;
import com.progov.model.BudgetItem;

import java.util.Comparator;

public class BudgetDataService {

    private final BudgetStore store = new BudgetStore();

    public BudgetData load() {
        return store.load();
    }

    public void save(BudgetData data) {
        store.save(data);
    }

    public void addRevenue(BudgetData data, String name, double amount) {
        data.revenues.add(new BudgetItem(System.currentTimeMillis(), name, amount));
        data.revenues.sort(Comparator.comparing(i -> i.name.toLowerCase()));
        save(data);
    }

    public void addExpense(BudgetData data, String name, double amount) {
        data.expenses.add(new BudgetItem(System.currentTimeMillis(), name, amount));
        data.expenses.sort(Comparator.comparing(i -> i.name.toLowerCase()));
        save(data);
    }

    public void deleteRevenue(BudgetData data, long id) {
        data.revenues.removeIf(i -> i.id == id);
        save(data);
    }

    public void deleteExpense(BudgetData data, long id) {
        data.expenses.removeIf(i -> i.id == id);
        save(data);
    }

    // Constraints όπως στο HTML σου
    public boolean passesConstraints(BudgetData data) {
        double rev = data.totalRevenue();
        double exp = data.totalExpenses();
        double bal = rev - exp;

        // 1) exp <= 105% rev
        if (rev > 0 && exp > rev * 1.05) return false;

        // 2) κανένα expense > 30% των expenses
        if (exp > 0) {
            for (var item : data.expenses) {
                if (item.amount > exp * 0.30) return false;
            }
        }

        // 3) reserve >= 10% rev  => balance >= 10% rev
        if (rev > 0 && bal < rev * 0.10) return false;

        return true;
    }

    // “Fix” όπως στο HTML: κόψε expenses αν παραβιάζει #1
    public void applyFixesIfNeeded(BudgetData data) {
        double rev = data.totalRevenue();
        double exp = data.totalExpenses();
        if (rev <= 0) return;
        double maxExp = rev * 1.05;

        if (exp <= maxExp) return;

        double over = exp - maxExp;

        // κόψε από το μεγαλύτερο έξοδο πρώτα
        data.expenses.sort((a,b) -> Double.compare(b.amount, a.amount));
        for (var item : data.expenses) {
            if (over <= 0) break;
            double cut = Math.min(item.amount, over);
            item.amount -= cut;
            over -= cut;
        }
        save(data);
    }
}

