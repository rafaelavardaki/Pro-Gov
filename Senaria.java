import java.util.Scanner;

public class Senaria {
    public static void showMenu() {
        System.out.println("\n--- Σενάρια Πολιτικής ---");
        System.out.println("1. Κοινωνικές δαπάνες");
        System.out.println("2. Φόροι");
        System.out.println("3. Παιδεία ");
        System.out.println("0. Έξοδος ");
    }

    public static void applyScenario(int scenario,
            String[] incNames, int[] incValues,
                    String[] exNames, int[] expValues) {
        Scanner sc = new Scanner(System.in);

        int percent;
        do {
            System.out.println("Δώσε ποσοστό μεταβολής από -30 έως 30 (εκτός από 0):");
            percent = sc.nextInt();
        } while (percent < -30 || percent > 30 || percent == 0);
        double rate = percent / 100.0;
        
        switch (scenario) {
            case 1:
                // Κοινωνικές δαπάνες
                modifyExpense(exNames, expValues,
                        "Επιδόματα και κοινωνικές παροχές", rate);
                modifyExpense(exNames, expValues,
                        "Δαπάνες υγείας", rate);
                break;

            case 2:
                // Φόροι
                modifyIncome(incNames, incValues,
                        "Φόρος εισοδήματος φυσικών προσώπων", rate);
                modifyIncome(incNames, incValues,
                        "Φόρος προστιθέμενης αξίας", rate);              
                break;
            
            case 3:
                // Παιδεία
                modifyExpense(exNames, expValues,
                        "Δαπάνες παιδείας", rate);
                break;

            case 0:
                System.out.println("Έξοδος από τα σενάρια.");
                return;
        }
        
        System.out.println("Εφαρμόστηκε μεταβολή " + percent + "% στο σενάριο.");
    }

    private static void modifyExpense(String[] names, int[] values,
            String target, double rate) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(target)) {
                values[i] += (int) (values[i] * rate);
            }
        }        
    }

    private static void modifyIncome(String[] names, int[] values,
            String target, double rate) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(target)) {
                values[i] += (int) (values[i] * rate);
            }
        }        
    }
}
