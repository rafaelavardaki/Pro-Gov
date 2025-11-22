public class Trial0 {
    public static void getBudget(String[] a1, int[] b1, String[] a2, int[] b2) {
        System.out.println("Έσοδα");
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i] + ":" + b1[i] );
        }
        System.out.println("Έξοδα");
        for (int i2 = 0; i2 < a2.length; i2++) {
            System.out.println(a2[i2] + ":" + b2[i2] );
        }
    }
}
