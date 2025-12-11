public class Task1_TriangularSequence {
    public static void printTriangular(int n) {
        printTriangularRec(1, 1, n);
    }

    private static void printTriangularRec(int current, int count, int n) {
        if (n == 0) {
            System.out.println();
            return;
        }

        System.out.print(current + " ");

        if (count == current) {
            printTriangularRec(current + 1, 1, n - 1);
        } else {
            printTriangularRec(current, count + 1, n - 1);
        }
    }
}