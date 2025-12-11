import java.util.Scanner;

public class Task16_CountMaxElements {
    private Scanner scanner = new Scanner(System.in);

    public int[] findMaxAndCount() {
        int num = scanner.nextInt();

        if (num == 0) {
            return new int[]{Integer.MIN_VALUE, 0};
        }

        int[] result = findMaxAndCount();

        if (num > result[0]) {
            return new int[]{num, 1};
        } else if (num == result[0]) {
            result[1]++;
            return result;
        } else {
            return result;
        }
    }
}