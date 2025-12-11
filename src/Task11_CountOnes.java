import java.util.Scanner;

public class Task11_CountOnes {
    private Scanner scanner = new Scanner(System.in);

    public int countOnes() {
        int num = scanner.nextInt();

        if (num == 0) {
            int next = scanner.nextInt();
            if (next == 0) {
                return 0;
            }
            return countOnes();
        }

        int count = (num == 1) ? 1 : 0;
        return count + countOnes();
    }
}