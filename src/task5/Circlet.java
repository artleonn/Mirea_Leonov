package task5;

public class Circlet {
    private double radius;
    private static int numberOfObjects = 0;

    public Circlet() {
        this(1.0);
    }

    public Circlet(double radius) {
        this.radius = radius;
        numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, area=%.2f]", radius, getArea());
    }
}