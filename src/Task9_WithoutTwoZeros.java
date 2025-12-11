public class Task9_WithoutTwoZeros {
    public static int countSequences(int a, int b) {
        if (a == 0 && b == 0) {
            return 1;
        }
        if (a < 0 || b < 0) {
            return 0;
        }
        if (a > b + 1) {
            return 0;
        }
        if (a == 0) {
            return 1;
        }
        if (b == 0) {
            return a == 1 ? 1 : 0;
        }

        return countSequences(a - 1, b - 1) + countSequences(a, b - 1);
    }
}