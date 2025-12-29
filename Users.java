package com.progov;

import java.util.Scanner;

public class Users {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int role;

        do {
            System.out.println("Επιλέξτε ρόλο:");
            System.out.println("1.Πολίτης");
            System.out.println("2.Υπουργός");
            System.out.println("0.Έξοδος");
            role = sc.nextInt();

            switch (role) {
                case 1:
                    citizenMenu(sc);
                    break;
                case 2:
                    ministerMenu(sc);
                    break;
                case 0:
                    System.out.println("Έξοδος από το πρόγραμμα...");
                    break;
                default:
                    System.out.println("Λάθος επιλογή");       
    
            }
        } while (role != 0);
        sc.close();
    }

    public static void citizenMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\nΛειτουργίες Πολίτη:");
            System.out.println("1.Προβολή Προϋπολογισμού");
            System.out.println("2.Σύγκριση με Παλαιότερα Δεδομένα");
            System.out.println("0.Έξοδος");

            choice = sc.nextInt();
            
            if (choice == 1) {
                Epiloges.getBudget(Trial1.category1, Trial1.values1, Trial1.cat2, Trial1.val2);
                } else if (choice == 2) {
    System.out.println("\n--- ΣΥΓΚΡΙΣΗ ΠΕΡΣΙ vs ΦΕΤΟΣ ---");
    System.out.println("1. Σύγκριση Εσόδων (Γράφημα)");
    System.out.println("2. Σύγκριση Εξόδων (Γράφημα)");
    System.out.println("3. Αριθμητική Σύγκριση (Κείμενο)");
    System.out.print("Επιλογή: ");
    int compareChoice = sc.nextInt();
    
    double[] incomeLastYear = BudgetComparator.getIncomeLastYear();
    double[] expensesLastYear = BudgetComparator.getExpensesLastYear();
    
    if(compareChoice == 1) {
        Diagram.diagramm3(Trial1.category1, Trial1.values1, incomeLastYear);
    } else if(compareChoice == 2) {
        Diagram.diagramm4(Trial1.cat2, Trial1.val2, expensesLastYear);
    } else if(compareChoice == 3) {
        BudgetComparator.compare(Trial1.category1, Trial1.values1, 
                               Trial1.cat2, Trial1.val2);
    }
}
            } else if (choice == 0) {
                System.out.println("Έξοδος από το μενού Πολίτη...");
            } else {
                System.out.println("Λάθος επιλογή.");
            }


        } while (choice != 0);
    }
}



