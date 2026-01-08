package com.progov.service;

import com.progov.model.Budget;

public class BudgetStore {
    private static final BudgetStore INSTANCE = new BudgetStore();
    private final Budget budget = new Budget();

    private BudgetStore() {}

    public static BudgetStore get() {
        return INSTANCE;
    }

    public Budget budget() {
        return budget;
    }
}
