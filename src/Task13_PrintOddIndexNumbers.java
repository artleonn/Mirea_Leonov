import java.util.Scanner;

public class Task13_PrintOddIndexNumbers {
    private Scanner scanner = new Scanner(System.in);
    private int index = 1;

    public void printOddIndexNumbers() {
        int num = scanner.nextInt();

        if (num == 0) {
            return;
        }

        if (index % 2 != 0) {
            System.out.print(num + " ");
        }

        index++;
        printOddIndexNumbers();
    }
}