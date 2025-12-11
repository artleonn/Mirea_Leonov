public class Task7_Factorization {
    public static void factorize(int n, int divisor) {
        if (n == 1) {
            return;
        }

        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            factorize(n / divisor, divisor);
        } else {
            factorize(n, divisor + 1);
        }
    }
}