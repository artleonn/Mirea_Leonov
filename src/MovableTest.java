// Файл: src/movable/MovableTest.java

public class MovableTest {
    public static void main(String[] args) {
        // 1. Тестирование MovablePoint
        System.out.println("=== Тестирование MovablePoint ===");
        MovablePoint point1 = new MovablePoint(0, 0, 2, 3);
        MovablePoint point2 = new MovablePoint(5, 5, 2, 3);

        System.out.println("Начальная позиция point1: " + point1);
        System.out.println("Начальная позиция point2: " + point2);

        point1.moveRight();
        point1.moveDown();
        System.out.println("point1 после moveRight() и moveDown(): " + point1);

        // 2. Тестирование speedTest()
        System.out.println("\n=== Тестирование speedTest() ===");
        MovablePoint point3 = new MovablePoint(0, 0, 1, 1);
        MovablePoint point4 = new MovablePoint(0, 0, 1, 1);
        MovablePoint point5 = new MovablePoint(0, 0, 3, 4);

        System.out.println("point1 и point2 имеют одинаковую скорость? " + point1.speedTest(point2));
        System.out.println("point3 и point4 имеют одинаковую скорость? " + point3.speedTest(point4));
        System.out.println("point3 и point5 имеют одинаковую скорость? " + point3.speedTest(point5));

        // 3. Тестирование MovableRectangle
        System.out.println("\n=== Тестирование MovableRectangle ===");
        MovableRectangle rect = new MovableRectangle(0, 0, 4, 3, 2, 2);
        System.out.println("Начальный прямоугольник: " + rect);
        System.out.println("Проверка скорости точек прямоугольника: " + rect.speedTest());

        rect.moveUp();
        rect.moveRight();
        System.out.println("После moveUp() и moveRight(): " + rect);

        // 4. Тестирование с разными скоростями (должен быть false)
        System.out.println("\n=== Тест с разными скоростями ===");
        MovablePoint slowPoint = new MovablePoint(0, 0, 1, 1);
        MovablePoint fastPoint = new MovablePoint(10, 10, 5, 5);
        System.out.println("slowPoint и fastPoint имеют одинаковую скорость? " + slowPoint.speedTest(fastPoint));

        // 5. Демонстрация полного движения
        System.out.println("\n=== Демонстрация полного движения прямоугольника ===");
        MovableRectangle demoRect = new MovableRectangle(0, 0, 5, 5, 1, 1);
        System.out.println("Исходное положение: " + demoRect);

        demoRect.moveDown();
        demoRect.moveRight();
        System.out.println("После moveDown() и moveRight(): " + demoRect);

        demoRect.moveUp();
        demoRect.moveLeft();
        System.out.println("После moveUp() и moveLeft(): " + demoRect);

        System.out.println("\n=== Тестирование завершено ===");
    }
}
