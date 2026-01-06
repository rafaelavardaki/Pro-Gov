package com.progov;

public class MenuEpilogwn {
    public static void getMenu() {
        System.out.println("\n--- Σύστημα Προϋπολογισμού ---"); /* θα γίνει με κουμπιά  */
        System.out.println("1. Εμφάνιση Στοιχείων Προϋπολογισμού");
        System.out.println("2. Eισαγωγή αλλαγών στα ήδη υπάρχοντα στοιχεία");
        System.out.println("3. Δημιουργία Διαγραμμάτων");
        System.out.println("4. Σύγκριση με παλαιότερους Προϋπολογισμούς");
        System.out.println("0. Έξοδος");
        System.out.println("Δώσε απάντηση 0,1,2,3 ή 4");

    }

    public static void getMenuP() {
        System.out.println("\nΛειτουργίες Πολίτη:");
        System.out.println("1.Προβολή Προϋπολογισμού");
        System.out.println("2.Σύγκριση με Παλαιότερα Δεδομένα");
        System.out.println("0.Έξοδος");
    }

    public static void getMenuC2() {
        System.out.println("\n--- ΣΥΓΚΡΙΣΗ ΠΕΡΣΙ vs ΦΕΤΟΣ ---");
        System.out.println("1. Σύγκριση Εσόδων (Γράφημα)");
        System.out.println("2. Σύγκριση Εξόδων (Γράφημα)");
        System.out.println("3. Αριθμητική Σύγκριση (Κείμενο)");
    }
}
