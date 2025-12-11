package task1;

public class ClassFTest {
    public static void main(String[] args) {
        F f = new F();

        System.out.println("1. " + f.i);
        System.out.println("2. " + f.s);
        f.imethod();
        f.smethod();

        System.out.println("6. " + F.s);
        F.smethod();
    }
}

class F {
    int i = 10;
    static String s = "static";

    void imethod() {
        System.out.println("Instance method called");
    }

    static void smethod() {
        System.out.println("Static method called");
    }
}