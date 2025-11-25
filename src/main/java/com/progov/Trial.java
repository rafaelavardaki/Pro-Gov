package com.progov;

public class Trial {
    public static void greet() {
        System.out.println ("Δώσε τιμές στις παρακάτω κατηγορίες.");
    }

    public static void budgetItem(String[] a, int[] b) {
        Trial.greet();
        for (int i = 0; i < b.length; i ++) {
            System.out.println(a[i] + " -> " );
            int arith = CheckVariables.checkingV();
            b[i] = arith;
        }
        System.out.println("Εμφάνιση στοιχείων ");
        for (int i=0; i < b.length; i++) {
            
            System.out.println(a[i] + " : " + b[i]);  /* Η εμφάνιση των στοιχείων με πίνακες */
        }
    }

    public static void comparison(int s1, int s2) {
        if (s1 > s2) {
            System.out.println("Ο κρατικός προϋπολογισμός είναι πλεονασματικός.");
        } else if (s1 < s2) {
            System.out.println("Ο κρατικός προϋπολογισμός είναι ελλειμματικός."); 
        } else {
            System.out.println("Ο κρατικός προϋπολογισμός είναι ισοσταθμισμένος.");
        }
    }

}