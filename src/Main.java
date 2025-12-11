import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 1 ===");
        Exception1 ex1 = new Exception1();
        try {
            ex1.exceptionDemo();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n=== Задание 2 ===");
        Exception2 ex2 = new Exception2();
        try {
            ex2.exceptionDemo();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getClass().getName());
        }

        System.out.println("\n=== Задание 5 ===");
        ThrowsDemo td = new ThrowsDemo();
        try {
            td.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        System.out.println("\n=== Задание 6 ===");
        ThrowsDemoModified tdm = new ThrowsDemoModified();
        try {
            tdm.printMessage("test");
            tdm.printMessage(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        System.out.println("\n=== Задание 7 ===");
        ThrowsDemoChained tdc = new ThrowsDemoChained();
        try {
            System.out.print("Enter key: ");
            tdc.getKey();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        scanner.close();
    }
}