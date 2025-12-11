package task3;

public class ClassCTest {
    Circle c = new Circle(5.0);

    public static void main(String[] args) {
        ClassCTest obj = new ClassCTest();
        obj.method1();
    }

    public void method1() {
        method2();
    }

    public static void method2() {
        ClassCTest obj = new ClassCTest();
        System.out.println("What is area " + obj.c.getArea());
    }
}