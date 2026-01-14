package com.progov.model;

import java.util.ArrayList;
import java.util.List;

public class BudgetData {
    public List<BudgetItem> revenues = new ArrayList<>();
    public List<BudgetItem> expenses = new ArrayList<>();

    public double totalRevenue() {
        return revenues.stream().mapToDouble(i -> i.amount).sum();
    }

    public double totalExpenses() {
        return expenses.stream().mapToDouble(i -> i.amount).sum();
    }

    public double balance() {
        return totalRevenue() - totalExpenses();
    }
}

