package com.progov;

public class BudgetComparator {
    private static double[] incomeLastYear = {10000, 8000, 20000, 4000, 3000, 1500, 1800, 800, 1000, 750, 2800, 600, 2500, 3800, 3500, 1900, 5000, 1000, 9000, 6000};
    
    private static double[] expensesLastYear = {17000, 15500, 11500, 9000, 8000, 4800, 6200, 2900, 3800, 5500, 3500, 2700, 2900, 3800, 2500, 3700, 4900, 5800, 12500, 6800};
    
    public static void compare(String[] incomeNames, double[] incomeNow,
                               String[] expenseNames, double[] expensesNow) {
        
        System.out.println("\n--- ΣΥΓΚΡΙΣΗ ΜΕ ΠΕΡΣΙ ---");
        
       
        // 1. ΕΣΟΔΑ
        System.out.println("\nΕΣΟΔΑ:");
        System.out.println("----------------------------");
        
        double totalIncomeLast = 0;
        double totalIncomeNow = 0;
        
        for (int i = 0; i < 20; i++) {
            double last = incomeLastYear[i];
            double now = incomeNow[i];
            double diff = now - last;
            
            totalIncomeLast = totalIncomeLast + last;
            totalIncomeNow = totalIncomeNow + now;
            
            System.out.print(incomeNames[i] + " | ");
            System.out.print("Πέρσι: " + last + " | ");
            System.out.print("Φέτος: " + now + " | ");
            System.out.println("Διαφορά: " + diff);
        }
        
        System.out.println("----------------------------");
        System.out.println("ΣΥΝΟΛΟ ΕΣΟΔΩΝ:");
        System.out.println("Πέρσι: " + totalIncomeLast);
        System.out.println("Φέτος: " + totalIncomeNow);
        System.out.println("Διαφορά: " + (totalIncomeNow - totalIncomeLast));
        
        // 2. ΕΞΟΔΑ
        System.out.println("\n\nΕΞΟΔΑ:");
        System.out.println("----------------------------");
        
        double totalExpensesLast = 0;
        double totalExpensesNow = 0;
        
        for (int i = 0; i < 20; i++) {
            double last = expensesLastYear[i];
            double now = expensesNow[i];
            double diff = now - last;
            
            totalExpensesLast = totalExpensesLast + last;
            totalExpensesNow = totalExpensesNow + now;
            
            System.out.print(expenseNames[i] + " | ");
            System.out.print("Πέρσι: " + last + " | ");
            System.out.print("Φέτος: " + now + " | ");
            System.out.println("Διαφορά: " + diff);
        }
        
        System.out.println("----------------------------");
        System.out.println("ΣΥΝΟΛΟ ΕΞΟΔΩΝ:");
        System.out.println("Πέρσι: " + totalExpensesLast);
        System.out.println("Φέτος: " + totalExpensesNow);
        System.out.println("Διαφορά: " + (totalExpensesNow - totalExpensesLast));
        
        // 3. ΑΠΟΤΕΛΕΣΜΑΤΑ
        System.out.println("\n\nΤΕΛΙΚΑ ΑΠΟΤΕΛΕΣΜΑΤΑ:");
        System.out.println("========================");
        
        double balanceLast = totalIncomeLast - totalExpensesLast;
        double balanceNow = totalIncomeNow - totalExpensesNow;
        
        System.out.println("ΠΕΡΣΙ:");
        System.out.println("  Έσοδα: " + totalIncomeLast);
        System.out.println("  Έξοδα: " + totalExpensesLast);
        System.out.println("  Ισοζύγιο: " + balanceLast);
        
        System.out.println("\nΦΕΤΟΣ:");
        System.out.println("  Έσοδα: " + totalIncomeNow);
        System.out.println("  Έξοδα: " + totalExpensesNow);
        System.out.println("  Ισοζύγιο: " + balanceNow);
        
        // 4. ΑΝΑΛΥΣΗ
        System.out.println("\nΑΝΑΛΥΣΗ:");
        System.out.println("--------");
        
        if (balanceLast > 0) {
            System.out.println("Πέρσι είχαμε ΠΛΕΟΝΑΣΜΑ");
        } else if (balanceLast < 0) {
            System.out.println("Πέρσι είχαμε ΕΛΛΕΙΜΜΑ");
        } else {
            System.out.println("Πέρσι είχαμε ΙΣΟΖΥΓΙΟ");
        }
        
        if (balanceNow > 0) {
            System.out.println("Φέτος έχουμε ΠΛΕΟΝΑΣΜΑ");
        } else if (balanceNow < 0) {
            System.out.println("Φέτος έχουμε ΕΛΛΕΙΜΜΑ");
        } else {
            System.out.println("Φέτος έχουμε ΙΣΟΖΥΓΙΟ");
        }
    }
    public static double[] getIncomeLastYear() {
    return incomeLastYear.clone();
}

public static double[] getExpensesLastYear() {
    return expensesLastYear.clone();
}
}
