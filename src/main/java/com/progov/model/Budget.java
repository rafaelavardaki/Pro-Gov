package com.progov.model;

public class Budget {
    private double incomeTax;
    private double vat;
    private double otherRevenue;

    private double salaries;
    private double pensions;
    private double otherExpenses;

    public double getIncomeTax() { return incomeTax; }
    public void setIncomeTax(double incomeTax) { this.incomeTax = incomeTax; }

    public double getVat() { return vat; }
    public void setVat(double vat) { this.vat = vat; }

    public double getOtherRevenue() { return otherRevenue; }
    public void setOtherRevenue(double otherRevenue) { this.otherRevenue = otherRevenue; }

    public double getSalaries() { return salaries; }
    public void setSalaries(double salaries) { this.salaries = salaries; }

    public double getPensions() { return pensions; }
    public void setPensions(double pensions) { this.pensions = pensions; }

    public double getOtherExpenses() { return otherExpenses; }
    public void setOtherExpenses(double otherExpenses) { this.otherExpenses = otherExpenses; }

    public double totalRevenue() {
        return incomeTax + vat + otherRevenue;
    }

    public double totalExpenses() {
        return salaries + pensions + otherExpenses;
    }

    public double balance() {
        return totalRevenue() - totalExpenses();
    }
}
