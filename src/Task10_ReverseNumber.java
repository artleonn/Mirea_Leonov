public class Task10_ReverseNumber {
    public static int reverse(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }
        return reverse(n / 10, reversed * 10 + n % 10);
    }
}
