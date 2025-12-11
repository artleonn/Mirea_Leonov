public class Task4_DigitSumCount {
    public static int countNumbers(int k, int s, int current, int sum) {
        if (current == k) {
            return sum == s ? 1 : 0;
        }

        int total = 0;
        int start = (current == 0) ? 1 : 0;

        for (int digit = start; digit <= 9; digit++) {
            if (sum + digit <= s) {
                total += countNumbers(k, s, current + 1, sum + digit);
            }
        }

        return total;
    }
}
