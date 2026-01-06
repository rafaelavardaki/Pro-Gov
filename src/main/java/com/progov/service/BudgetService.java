package com.progov.service;

import com.progov.model.Budget;

public class BudgetService {

    private final BudgetStore store = BudgetStore.get();

    public Budget getBudget() {
        return store.budget();
    }

    // Απλός περιορισμός: τα έξοδα δεν πρέπει να ξεπερνούν τα έσοδα
    public boolean passesConstraints() {
        return getBudget().totalExpenses() <= getBudget().totalRevenue();
    }

    // “Εφαρμογή αλλαγών” (απλό demo):
    // Αν έξοδα > έσοδα, μειώνουμε proportionally τα "otherExpenses"
    public void applyFixesIfNeeded() {
        Budget b = getBudget();
        double rev = b.totalRevenue();
        double exp = b.totalExpenses();

        if (exp <= rev) return;

        double excess = exp - rev;
        double newOther = Math.max(0, b.getOtherExpenses() - excess);
        b.setOtherExpenses(newOther);
    }
}
