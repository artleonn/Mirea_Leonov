import java.util.Scanner;

public class Task17_MaximumSequence {
    private Scanner scanner = new Scanner(System.in);

    public int findMax() {
        int num = scanner.nextInt();

        if (num == 0) {
            return Integer.MIN_VALUE;
        }

        int nextMax = findMax();
        return Math.max(num, nextMax);
    }
}