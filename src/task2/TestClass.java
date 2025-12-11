package task2;

public class TestClass {
    int count;

    public static void main(String[] args) {
        System.out.println("Main method is always static");
        TestClass obj = new TestClass();
        System.out.println("Count: " + obj.getCount());
        System.out.println("Factorial 5: " + factorial(5));
    }

    public int getCount() {
        return count;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
}