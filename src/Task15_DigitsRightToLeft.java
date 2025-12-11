public class Task15_DigitsRightToLeft {
    public static void printDigitsRightToLeft(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(n % 10 + " ");
        printDigitsRightToLeft(n / 10);
    }
}