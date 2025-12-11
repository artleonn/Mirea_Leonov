package task5;

public class FindLargestCircle {
    public static void main(String[] args) {
        // Создаем массив из 10 кругов со случайными радиусами
        Circlet[] circles = new Circlet[10];

        System.out.println("Создаем массив из 10 кругов:");
        for (int i = 0; i < circles.length; i++) {
            double radius = Math.random() * 50 + 1; // радиус от 1 до 51
            circles[i] = new Circlet(radius);
            System.out.printf("Круг %d: радиус=%.2f, площадь=%.2f%n",
                    i + 1, circles[i].getRadius(), circles[i].getArea());
        }

        // Находим круг с максимальной площадью
        Circlet largestCircle = circles[0];
        int largestIndex = 0;

        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > largestCircle.getArea()) {
                largestCircle = circles[i];
                largestIndex = i;
            }
        }

        System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
        System.out.printf("Всего создано кругов: %d%n", Circlet.getNumberOfObjects());
        System.out.printf("Круг с самой большой площадью:%n");
        System.out.printf("  Индекс в массиве: %d%n", largestIndex);
        System.out.printf("  Радиус: %.2f%n", largestCircle.getRadius());
        System.out.printf("  Площадь: %.2f%n", largestCircle.getArea());
    }
}