package com.progov;

public class BudgetComparator {
    
    public static void compare(String[] incomeNames, double[] incomeNow,
                               String[] expenseNames, double[] expensesNow) {
        
        System.out.println("\n--- ΣΥΓΚΡΙΣΗ ΜΕ ΠΕΡΣΙ ---");
        
        // Περσινά έσοδα 
        double[] incomeLastYear = new double[20];
        incomeLastYear[0] = 10000;
        incomeLastYear[1] = 8000;
        incomeLastYear[2] = 20000;
        incomeLastYear[3] = 4000;
        incomeLastYear[4] = 3000;
        incomeLastYear[5] = 1500;
        incomeLastYear[6] = 1800;
        incomeLastYear[7] = 800;
        incomeLastYear[8] = 1000;
        incomeLastYear[9] = 750;
        incomeLastYear[10] = 2800;
        incomeLastYear[11] = 600;
        incomeLastYear[12] = 2500;
        incomeLastYear[13] = 3800;
        incomeLastYear[14] = 3500;
        incomeLastYear[15] = 1900;
        incomeLastYear[16] = 5000;
        incomeLastYear[17] = 1000;
        incomeLastYear[18] = 9000;
        incomeLastYear[19] = 6000;
        
        // Περσινά έξοδα
        double[] expensesLastYear = new double[20];
        expensesLastYear[0] = 17000;
        expensesLastYear[1] = 15500;
        expensesLastYear[2] = 11500;
        expensesLastYear[3] = 9000;
        expensesLastYear[4] = 8000;
        expensesLastYear[5] = 4800;
        expensesLastYear[6] = 6200;
        expensesLastYear[7] = 2900;
        expensesLastYear[8] = 3800;
        expensesLastYear[9] = 5500;
        expensesLastYear[10] = 3500;
        expensesLastYear[11] = 2700;
        expensesLastYear[12] = 2900;
        expensesLastYear[13] = 3800;
        expensesLastYear[14] = 2500;
        expensesLastYear[15] = 3700;
        expensesLastYear[16] = 4900;
        expensesLastYear[17] = 5800;
        expensesLastYear[18] = 12500;
        expensesLastYear[19] = 6800;
        
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
}