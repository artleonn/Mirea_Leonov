import java.util.Scanner;

public class Task12_PrintOddNumbers {
    private Scanner scanner = new Scanner(System.in);

    public void printOdds() {
        int num = scanner.nextInt();

        if (num == 0) {
            return;
        }

        if (num % 2 != 0) {
            System.out.print(num + " ");
        }

        printOdds();
    }
}