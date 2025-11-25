import java.util.Scanner;

public class Changes {
    public static String process(String[] A, int[] B) {
        System.out.println("Ποια κατηγορία θα ήθελες να αλλάξεις;");
        for (int i = 0 ; i < A.lenght ; i++ ) {
                System.out.println((i+1) + A[i]);
            }
            int katigoria = scanner.nextInt();
            System.out.println(A[katigoria-1] + "-> ");
            int timi = scanner.nextInt();
            B[katigoria-1] = timi;
            System.out.println(A[katigoria-1] + ":" + B[katigoria-1]);

    }
    do {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Σε ποιον κλάδο θα ήθελες να κάνεις αλλαγές;");
        System.out.println("1.Έσοδα, 2.Έξοδα");
        int epilogi = scanner.nextInt();
        if (epilogi == 1) {
            System.out.println("Ποια κατηγορία θα ήθελες να αλλάξεις;");
            for (int i = 0 ; i < Category.lenght ; i++ ) {
                System.out.println((i+1) + Category[i]);
            }
            int katigoria = scanner.nextInt();
            System.out.println(Category[katigoria-1] + "-> ");
            int timi = scanner.nextInt();
            Value[katigoria-1] = timi;
            System.out.println(Category[katigoria-1] + ":" + Value[katigoria-1]);

        } else {
            int y = 2;
        }
        System.out.println("Θα ήθελες να γίνει κάποια άλλη αλλαγή;");
        System.out.println("1.Ναι, 2.Όχι");
        int answer = scanner.nextInt();
    } while (answer == 1);
}
