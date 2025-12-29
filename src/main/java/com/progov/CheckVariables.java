package com.progov;
import java.util.Scanner;

public class CheckVariables {
    public static double checkingV() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        double y = 0;

        do { 
            y = in.nextDouble(); /* έλεγχοι μεταβλητών */
            if (y >= 0) {
                flag = true;
            } else {
                System.out.println("\nΔώσε ΘΕΤΙΚΟ αριθμό!");
            }
            
        } while (flag == false);
        return y;

    }
    public static int checkingV1() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int y = 0;

        do { 
            y = in.nextInt();
            if (y >= 0 && y < 5) {
                flag = true;
            } else {
                System.out.println("\nΔώσε 0,1,2,3 ή 4"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
            }
            
        } while (flag == false);
        return y;

    }
    public static int checkingV2() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int y = 0;

        do { 
            y = in.nextInt();
            if (y > 0 && y < 21) {
                flag = true;
            } else {
                System.out.println("\nΔώσε αριθμό από 1 εώς 20!"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
            }
            
        } while (flag == false);
        return y;
    }
    public static int checkingV3() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int y = 0;

        do { 
            y = in.nextInt();
            if (y == 1 || y == 2) {
                flag = true;
            } else {
                System.out.println("\nΔώσε 1 ή 2"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
            }
            
        } while (flag == false);
        return y;

    }

}