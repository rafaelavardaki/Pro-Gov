import java.util.Scanner;

public class Trial {
    public static void greet() {
        System.out.println ("Δώσε τιμές στις παρακάτω κατηγορίες.");
    }

    public static void budgetItem(String[] a, int[] b) {
        Trial.greet();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < b.length; i ++) {
            System.out.println(a[i] + " -> " );
            int arith = scanner.nextInt();
            b[i] = arith;
        }
        for (int i=0; i < b.length; i++) {
            System.out.println("Εμφάνιση στοιχείων ");
            System.out.println(a[i] + " : " + b[i]);
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