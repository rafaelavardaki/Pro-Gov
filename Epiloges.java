import java.util.Locale.Category;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Σε ποια απο τις κατηγορίεσ θα ήθελες να αλλάξεις τιμή;");
        for (int i = 0 ; i < a.length ; i++ ) {
                System.out.println((i+1) + ' ' +  a[i]);
        }
        System.out.println(" Δώσε κατηγορία από τις παραπάνω ");
        int katigoria = scanner.nextInt();  /*na ginei elegxos timwn */
        System.out.println(a[katigoria-1] + "-> ");
        System.out.println("Δώσε τιμή για την παραπάνω κατηγορία ");
        int timi = scanner.nextInt();  /*na ginei elegxos timwn */
        b[katigoria-1] = timi;
        System.out.println(a[katigoria-1] + ":" + b[katigoria-1]);
        
    }

    public static void changeBudget(String[] a1, int[] b1, String[] a2, int[] b2) {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Σε ποιον κλάδο θα ήθελες να κάνεις αλλαγές;");
            System.out.println("1.Έσοδα, 2.Έξοδα");
            int epilogi = scanner.nextInt(); /*na ginei elegxos timwn */
            if (epilogi == 1) {
                Epiloges.changesMain(a1, b1);
            } else {
                Epiloges.changesMain(a2, b2);
            }
            System.out.println("Θα ήθελες να γίνει κάποια ακόμα αλλαγή;");
            System.out.println("1.Ναι, 2.Όχι");
            int answer = scanner.nextInt(); /*na ginei elegxos timwn */
        } while (answer == 1);
    }
}
