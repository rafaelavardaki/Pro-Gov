package com.progov;
import java.util.Scanner;

public class CheckVariables {
    public static int checkingV() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int y = 0;

        do { 
            y = in.nextInt(); /* έλεγχοι μεταβλητών */
            if (y >= 0) {
                flag = true;
            } else {
                System.out.println("Δώσε ΘΕΤΙΚΟ αριθμό!");
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
            if (y >= 0 && y < 3) {
                flag = true;
            } else {
                System.out.println("Δώσε 0,1 ή 2"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
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
                System.out.println("Δώσε αριθμό από 1 εώς 20!"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
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
                System.out.println("Δώσε 1 ή 2"); /* οταν μεγαλωσει το μενου επιλογων θα αλλαξουν και τα ορια!!! */
            }
            
        } while (flag == false);
        return y;

    }

}