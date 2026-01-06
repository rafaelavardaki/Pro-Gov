package com.progov;

public class Epiloges {
   
    public static void getBudget(String[] a1, double[] b1, String[] a2, double[] b2) {
        System.out.println("\nΈσοδα");
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i] + " : " + b1[i]);
        }
        System.out.println("\nΈξοδα");
        for (int i2 = 0; i2 < a2.length; i2++) {
            System.out.println(a2[i2] + " : " + b2[i2]);
        }
    }

    public static void changeValue(double j[], int kat, double tim) {
        j[kat-1] = tim;
    }

    public static void changesMain(String[] a, double[] b) {
        System.out.println("\nΣε ποια απο τις κατηγορίες θα ήθελες να αλλάξεις τιμή;");
        for (String t : a ) {
            System.out.println(t);
        }
        System.out.println("\nΔώσε κατηγορία από τις παραπάνω");

        int katigoria = CheckVariables.checkingV2();
        System.out.println("\n" + a[katigoria-1] + "-> ");
        System.out.println("\nΔώσε τιμή για την παραπάνω κατηγορία ");
        double timi = CheckVariables.checkingV();
        Epiloges.changeValue(b, katigoria, timi);
        System.out.println("\n" + a[katigoria-1] + " : " + b[katigoria-1]);
        
    }


    public static void changeBudget(String[] a1, double[] b1, String[] a2, double[] b2) {
        int r = 0;
        do {

            
            System.out.println("\nΣε ποιον κλάδο θα ήθελες να κάνεις αλλαγές;");
            System.out.println("1.Έσοδα, 2.Έξοδα");
            int epilogi = CheckVariables.checkingV3(); 
            if (epilogi == 1) {
                Epiloges.changesMain(a1, b1);
            } else {
                Epiloges.changesMain(a2, b2);
            }
            System.out.println("\nΘα ήθελες να γίνει κάποια ακόμα αλλαγή;");
            System.out.println("1.Ναι, 2.Όχι");

            int answer = CheckVariables.checkingV3(); 
            if (answer == 2) {
                r = 1;
            }
        } while (r == 0);
    }
}
