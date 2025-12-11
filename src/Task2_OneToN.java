public class Task2_OneToN {
    public static void printNumbers(int current, int n) {
        if (current > n) {
            System.out.println();
            return;
        }

        System.out.print(current + " ");
        printNumbers(current + 1, n);
    }
}