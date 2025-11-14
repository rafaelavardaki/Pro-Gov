import java.util.Scanner;

public class Esoda1 {
    public void greet() {
        System.out.println ("Δώσε τιμές στις παρακάτω κατηγορίες.");
    }

    public static void main(String[] args) {
        Esoda1 esoda = new Esoda1();
        esoda.greet();
        String[] Category = {"A", "B", "G"};
        int[] Values = new int[4];
        Scanner scanner = new Scanner(System.in);
    }
}
