public class Task6_PrimeCheck {
    public static boolean isPrime(int n, int divisor) {
        if (n <= 2) {
            return n == 2;
        }
        if (n % divisor == 0) {
            return false;
        }
        if (divisor * divisor > n) {
            return true;
        }
        return isPrime(n, divisor + 1);
    }
}