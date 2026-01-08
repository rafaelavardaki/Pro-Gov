
package com.progov;


import java.util.Scanner; 

public class Users {
    public static void main(String[] args) {
        String[] category1 = {"1. Φόρος εισοδήματος φυσικών προσώπων", "2. Φόρος εισοδήματος νομικών προσώπων", "3. Φόρος προστιθέμενης αξίας", "4. Ειδικός φόρος κατανάλωσης καυσίμων", "5. Ειδικός φόρος κατανάλωσης καπνού", "6. Ειδικός φόρος κατανάλωσης αλκοόλ", "7. Φόρος ακίνητης περιουσίας", "8. Τέλη κυκλοφορίας", "9. Τεκμήρια/έμμεσοι φόροι περιουσίας", "10. Τέλη χαρτοσήμου", "11. Έσοδα από κρατικές υπηρεσίες", "12. Πρόστιμα και κυρώσεις", "13. Έσοδα από παραχωρήσεις/άδειες", "14. Έσοδα από αποκρατικοποιήσεις", "15. Έσοδα από αξιοποίηση δημόσιας περιουσίας", "16. Ανταποδοτικά τέλη ΟΤΑ", "17. Κέρδη από δημόσιες επιχειρήσεις", "18. Τόκοι από διαθέσιμα του Δημοσίου", "19. Ευρωπαϊκά κονδύλια / ΕΣΠΑ" , "20. Δάνεια και χρηματοδοτήσεις από διεθνείς οργανισμούς" };
        double[] values1 = new double[20];
        String[] cat2 = {"1. Μισθοί δημοσίων υπαλλήλων", "2. Συντάξεις δημοσίου", "3. Επιδόματα και κοινωνικές παροχές", "4. Δαπάνες υγείας", "5. Δαπάνες παιδείας", "6. Δαπάνες για δημόσια διοίκηση", "7. Ασφάλεια και άμυνα", "8. Δικαστικό σύστημα", "9. Κτιριακές υποδομές", "10. Οδικά έργα-αυτοκινητόδρομοι", "11. Σιδηροδρομικά έργα", "12. Ψηφιακός μετασχηματισμός/πληροφορική", "13. Έργα ενέργειας-ΑΠΕ", "14. Έργα ύδρευσης και αποχέτευσης", "15. Έργα πολιτικής προστασίας", 
        "16. Επιχορηγήσεις σε ΟΤΑ", "17. Επιχορηγήσεις σε νοσοκομεία/πανεπιστήμια", "18. Επιδοτήσεις επιχειρήσεων", "19. Εξυπηρέτηση δημόσιου χρέους", "20. Αποπληρωμή χρεολυσίων"};
        double[] val2 = new double[20];

        Scanner sc = new Scanner(System.in);
        int role;

        do {
            System.out.println("\nΕπιλέξτε ρόλο:");
            System.out.println("1.Πολίτης");
            System.out.println("2.Υπουργός");
            System.out.println("0.Έξοδος");
            role = sc.nextInt();

            switch (role) {
                case 1:
                    citizenMenu(sc, category1, values1, cat2, val2);
                    break;
                case 2:
                    ministerMenu(category1, values1, cat2, val2);
                    break;
                case 0:
                    System.out.println("\nΈξοδος από το πρόγραμμα...");
                    break;
                default:
                    System.out.println("Λάθος επιλογή");       
    
            }
        } while (role != 0);
        sc.close();
    }

    public static void citizenMenu(Scanner sc, String[] cate1, double[] vals1, String[] cate2, double[] vals2) {
        int choice;
        do {
            MenuEpilogwn.getMenuP();

            choice = CheckVariables.checkingV4();
            
            if (choice == 1) {
                Epiloges.getBudget(cate1, vals1, cate2, vals2);
            } else if (choice == 2) {
                MenuEpilogwn.getMenuC2();
                System.out.print("Επιλογή: ");
                int compareChoice = CheckVariables.checkingV5();
    
                double[] incomeLastYear = {10000, 8000, 20000,4000,3000,1500,1800,800,1000,750,2800,600,2500,3800,3500,1900,5000,1000,9000,6000};
                double[] expensesLastYear = {17000,15500,11500,9000,8000,4800,6200,2900,3800,5500,3500,2700,2900,3800,2500,3700,4900,5800,12500,6800};
                
                    if (compareChoice == 1) {
                        System.out.println("1");
                    } else if(compareChoice == 2) {
                        System.out.println("2");
                    } else {
                        BudgetComparator.compare(cate1, vals1, cate2, vals2); } 
            
            } else if (choice == 0) {
                    System.out.println("\nΈξοδος από το μενού Πολίτη...\n");
            }

        } while (choice != 0); 
    } 

    public static void ministerMenu(String[] category1, double[] values1, String[] cat2, double[] val2) {
        
        System.out.println("\nΈΣΟΔΑ:");
        Trial.budgetItem(category1, values1);
        
        System.out.println("\nΈΞΟΔΑ:");
        Trial.budgetItem(cat2, val2);
        double sum1 = Trial.sumCalc(values1);
        double sum2 = Trial.sumCalc(val2);
        System.out.println("\nΈσοδα = " + sum1);
        System.out.println("Έξοδα = " + sum2);

        Trial.comparison(sum1, sum2);
        
        int x = 0;
        do { 
            MenuEpilogwn.getMenu();
            int epil = CheckVariables.checkingV1();
            switch (epil) {
                case 1 -> Epiloges.getBudget(category1, values1, cat2, val2);
                case 2 -> Epiloges.changeBudget(category1, values1, cat2, val2); 
                case 3 -> {
                    Diagram.diagramm1(category1, values1);
                    Diagram.diagramm2(cat2, val2);
                }
                case 4 -> BudgetComparator.compare(category1, values1, cat2, val2);
                default -> {
                    x = 1;
                    System.out.println("\nΈξοδος από το μενού Υπουργός...\n"); 
                }
            }
        
        } while (x == 0);
    }
}
