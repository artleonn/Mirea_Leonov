public class Task14_DigitsLeftToRight {
    public static void printDigitsLeftToRight(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }

        printDigitsLeftToRight(n / 10);
        System.out.print(n % 10 + " ");
    }
}