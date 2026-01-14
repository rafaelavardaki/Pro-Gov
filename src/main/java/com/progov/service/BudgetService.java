package com.progov.service;

import com.progov.model.Budget;

public class BudgetService {

    private final Budget budget = new Budget();

    public Budget getBudget() {
        return budget;
    }

    // Απλός κανόνας: Έξοδα <= Έσοδα
    public boolean passesConstraints() {
        return budget.totalExpenses() <= budget.totalRevenue();
    }

    // Αν παραβιάζεται ο κανόνας, "κόβει" τα άλλα έξοδα ώστε να χωρέσουν
    public void applyFixesIfNeeded() {
        double rev = budget.totalRevenue();
        double exp = budget.totalExpenses();

        if (exp <= rev) return;

        // μειώνουμε τα "OtherExpenses" όσο χρειάζεται
        double over = exp - rev;
        double newOther = Math.max(0, budget.getOtherExpenses() - over);
        budget.setOtherExpenses(newOther);
    }
}
