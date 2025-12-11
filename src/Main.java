import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу (1-17):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.print("Введите n: ");
                int n1 = scanner.nextInt();
                Task1_TriangularSequence.printTriangular(n1);
                break;
            case 2:
                System.out.print("Введите n: ");
                int n2 = scanner.nextInt();
                Task2_OneToN.printNumbers(1, n2);
                break;
            case 3:
                System.out.print("Введите A: ");
                int a3 = scanner.nextInt();
                System.out.print("Введите B: ");
                int b3 = scanner.nextInt();
                Task3_AToB.printFromAToB(a3, b3);
                break;
            case 4:
                System.out.print("Введите k: ");
                int k4 = scanner.nextInt();
                System.out.print("Введите s: ");
                int s4 = scanner.nextInt();
                int count4 = Task4_DigitSumCount.countNumbers(k4, s4, 0, 0);
                System.out.println(count4);
                break;
            case 5:
                System.out.print("Введите N: ");
                int n5 = scanner.nextInt();
                int sum5 = Task5_DigitSum.sumDigits(n5);
                System.out.println(sum5);
                break;
            case 6:
                System.out.print("Введите n: ");
                int n6 = scanner.nextInt();
                boolean prime6 = Task6_PrimeCheck.isPrime(n6, 2);
                System.out.println(prime6 ? "YES" : "NO");
                break;
            case 7:
                System.out.print("Введите n: ");
                int n7 = scanner.nextInt();
                Task7_Factorization.factorize(n7, 2);
                break;
            case 8:
                System.out.print("Введите слово: ");
                String word8 = scanner.next();
                boolean palindrome8 = Task8_Palindrome.isPalindrome(word8, 0, word8.length() - 1);
                System.out.println(palindrome8 ? "YES" : "NO");
                break;
            case 9:
                System.out.print("Введите a: ");
                int a9 = scanner.nextInt();
                System.out.print("Введите b: ");
                int b9 = scanner.nextInt();
                int count9 = Task9_WithoutTwoZeros.countSequences(a9, b9);
                System.out.println(count9);
                break;
            case 10:
                System.out.print("Введите n: ");
                int n10 = scanner.nextInt();
                int reversed10 = Task10_ReverseNumber.reverse(n10, 0);
                System.out.println(reversed10);
                break;
            case 11:
                Task11_CountOnes task11 = new Task11_CountOnes();
                int result11 = task11.countOnes();
                System.out.println(result11);
                break;
            case 12:
                Task12_PrintOddNumbers task12 = new Task12_PrintOddNumbers();
                task12.printOdds();
                break;
            case 13:
                Task13_PrintOddIndexNumbers task13 = new Task13_PrintOddIndexNumbers();
                task13.printOddIndexNumbers();
                break;
            case 14:
                System.out.print("Введите N: ");
                int n14 = scanner.nextInt();
                Task14_DigitsLeftToRight.printDigitsLeftToRight(n14);
                break;
            case 15:
                System.out.print("Введите N: ");
                int n15 = scanner.nextInt();
                Task15_DigitsRightToLeft.printDigitsRightToLeft(n15);
                break;
            case 16:
                Task16_CountMaxElements task16 = new Task16_CountMaxElements();
                int[] result16 = task16.findMaxAndCount();
                System.out.println(result16[1]);
                break;
            case 17:
                Task17_MaximumSequence task17 = new Task17_MaximumSequence();
                int max17 = task17.findMax();
                System.out.println(max17);
                break;
            default:
                System.out.println("Неверный номер задачи");
        }

        scanner.close();
    }
}