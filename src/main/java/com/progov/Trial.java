package com.progov;

public class Trial {
    public static void greet() {
        System.out.println ("Δώσε τιμές στις παρακάτω κατηγορίες.");
    }

    public static void budgetItem(String[] a, double[] b, String type) {
        Trial.greet();
        for (int i = 0; i < b.length; i ++) {
            System.out.println(a[i] + " -> " );
            double arith = CheckVariables.checkingV();
            b[i] = arith;
            DatabaseConnection.saveBudgetItem(type, a[i], arith);
        }
        System.out.println("\nΕμφάνιση στοιχείων ");
        for (int i=0; i < b.length; i++) {
            
            System.out.println(a[i] + " : " + b[i]);  /* Η εμφάνιση των στοιχείων με πίνακες */
        }
    }

    public static void comparison(double s1, double s2) {
        if (s1 > s2) {
            System.out.println("\nΟ κρατικός προϋπολογισμός είναι πλεονασματικός.");
        } else if (s1 < s2) {
            System.out.println("\nΟ κρατικός προϋπολογισμός είναι ελλειμματικός."); 
        } else {
            System.out.println("\nΟ κρατικός προϋπολογισμός είναι ισοσταθμισμένος.");
        }
    }

    public static double sumCalc(double[] vals) {
        double sum = 0;
        for (int i = 0; i < vals.length; i++ ) {
            sum = sum + vals[i];
        }
        return sum;
    }

}