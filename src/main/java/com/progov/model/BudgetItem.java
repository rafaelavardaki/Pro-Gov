package com.progov.model;

public class BudgetItem {
    public long id;
    public String name;
    public double amount;

    public BudgetItem() {}

    public BudgetItem(long id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
