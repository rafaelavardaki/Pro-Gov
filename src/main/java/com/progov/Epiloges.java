package com.progov;

public class Epiloges {
   
    public static void getBudget(String[] a1, int[] b1, String[] a2, int[] b2) {
        System.out.println("Έσοδα");
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i] + ":" + b1[i] );
        }
        System.out.println("Έξοδα");
        for (int i2 = 0; i2 < a2.length; i2++) {
            System.out.println(a2[i2] + ":" + b2[i2] );
        }
    }

    public static void changesMain(String[] a, int[] b) {
        System.out.println("Σε ποια απο τις κατηγορίεσ θα ήθελες να αλλάξεις τιμή;");
        int g = 0;
        for (int t = 0 ; t < a.length ; t++ ) {
            g++;
            System.out.println((g) + ' ' +  a[t]);
        }
        System.out.println("Δώσε κατηγορία από τις παραπάνω");

        int katigoria = CheckVariables.checkingV2();
        System.out.println(a[katigoria-1] + "-> ");
        System.out.println("Δώσε τιμή για την παραπάνω κατηγορία ");
        int timi = CheckVariables.checkingV();
        b[katigoria-1] = timi;
        System.out.println(a[katigoria-1] + ":" + b[katigoria-1]);
        
    }

    public static void changeBudget(String[] a1, int[] b1, String[] a2, int[] b2) {
        int r = 0;
        do {

            
            System.out.println("Σε ποιον κλάδο θα ήθελες να κάνεις αλλαγές;");
            System.out.println("1.Έσοδα, 2.Έξοδα");
            int epilogi = CheckVariables.checkingV3(); 
            if (epilogi == 1) {
                Epiloges.changesMain(a1, b1);
            } else {
                Epiloges.changesMain(a2, b2);
            }
            System.out.println("Θα ήθελες να γίνει κάποια ακόμα αλλαγή;");
            System.out.println("1.Ναι, 2.Όχι");

            int answer = CheckVariables.checkingV3(); 
            if (answer == 2) {
                r = 1;
            }
        } while (r == 0);
    }
}
