public class Stats {
    // 1. ΣΥΝΟΨΗ ΠΡΟΫΠΟΛΟΓΙΣΜΟΥ
    public static void summary(int[] income, int[] expenses) {
        int sumIncome = 0;
        int sumExpenses =0;

        for (int i = 0; i < income.length; i++) {
            sumIncome += income[i];
            sumExpenses += expenses[i];
        }
        System.out.println("\n--- Σύνοψη Προϋπολογισμού ---");
        System.out.println("Σύνολο Εσόδων: " + sumIncome);
        System.out.println("Σύνολο Εξόδων: " + sumExpenses);
    }

    // 2. ΜΕΓΑΛΥΤΕΡΟ ΕΣΟΔΟ & ΜΕΓΑΛΥΤΕΡΗ ΔΑΠΑΝΗ
    public static void maxCategories(String[] incNames, int[] incValues,
            String[] expNames, int[] expValues) {
        int maxInc = incValues[0];
        int posInc = 0;
        int maxExp = expValues[0];
        int posExp = 0;

        for (int i = 1; i < incValues.length; i++) {
            if (incValues[i] > maxInc) {
                maxInc = incValues[i];
                posInc = i;
            }
            if (expValues[i] > maxExp) {
                maxExp = expValues[i];
                posExp = i;
            }
        }
        System.out.println("\n--- Μεγαλύτερες Κατηγορίες ---");
        System.out.println("Μεγαλύτερο Έσοδο: "
        + incNames[posInc] + " -> " + maxInc);
        System.out.println("Μεγαλύτερη Δαπάνη: "
        + expNames[posExp] + " -> " + maxExp);   
    }

    // 3. ΠΟΣΟΣΤΑ ΚΑΤΗΓΟΡΙΩΝ
    public static void percentages(String[] names, int[] values) {
        int total = 0;

        for (int v : values) {
            total += v;
        }
        
        System.out.println("\n--- Ποσοστά Κατηγοριών ---");

        if (total == 0) {
            System.out.println("Δεν υπάρχουν διαθέσιμα δεδομένα.");
            return;
        }
        for (int i = 0; i < values.length; i++) {
            double percent = (values[i] * 100.0) / total;
            System.out.printf("%s: %.2f%%\n", names[i], percent);
        }
    }
}   
