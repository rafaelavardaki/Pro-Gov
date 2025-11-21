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
            System.out.println(a[i] + " : " + b[i]);
        }
    }
}