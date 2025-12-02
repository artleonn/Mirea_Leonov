import movable.*;
import nameable.*;
import priceable.*;
import printable.*;
import computerstore.*;
import temperature.*;
import stringbuilder.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Практическая работа №6: Интерфейсы в Java ===\n");

        // Задание 1 и 2: Movable объекты
        System.out.println("1-2. Movable объекты:");
        MovablePoint point = new MovablePoint(0, 0, 2, 3);
        MovableCircle circle = new MovableCircle(5, 5, 1, 1, 10);
        MovableRectangle rectangle = new MovableRectangle(0, 0, 10, 5, 3, 3);

        System.out.println("Начальное состояние:");
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);

        point.moveRight();
        point.moveUp();
        circle.moveDown();
        circle.moveLeft();
        rectangle.moveRight();
        rectangle.moveDown();

        System.out.println("\nПосле перемещения:");
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);

        // Задание 3: Nameable
        System.out.println("\n3. Nameable объекты:");
        Nameable[] nameableObjects = {
                new Planet("Земля"),
                new Car("Toyota Camry"),
                new Animal("Лев")
        };

        for (Nameable n : nameableObjects) {
            System.out.println(n.getName());
        }

        // Задание 4: Priceable
        System.out.println("\n4. Priceable объекты:");
        Priceable[] priceableObjects = {
                new Product("Ноутбук", 1500.0),
                new Service("Ремонт", 50.0, 3)
        };

        for (Priceable p : priceableObjects) {
            System.out.println(p + ", цена: " + p.getPrice());
        }

        // Задание 6-9: Printable
        System.out.println("\n6-9. Printable объекты:");
        Printable[] printableObjects = {
                new Book("Война и мир"),
                new Magazine("National Geographic"),
                new ShopPrintable("Книжный магазин"),
                new Book("Преступление и наказание")
        };

        for (Printable p : printableObjects) {
            p.print();
        }

        // Задание 10: Компьютерный магазин
        System.out.println("\n10. Компьютерный магазин:");
        Shop shop = demonstrateComputerShop();

        // Задание 11: Конвертер температуры
        System.out.println("\n11. Конвертер температуры:");
        TemperatureConverter converter = new TemperatureConverter(25.0);
        converter.convert();

        converter.setCelsius(0.0);
        converter.convert();

        // Задание 12: StringBuilder с undo
        System.out.println("\n12. StringBuilder с undo:");
        demonstrateUndoableStringBuilder();

        // Задание 13: Observable StringBuilder
        System.out.println("\n13. Observable StringBuilder:");
        demonstrateObservableStringBuilder();

        System.out.println("\n14. Отчет готов!");


        System.out.println("\nДемонстрация ввода компьютера с клавиатуры:");
        System.out.println("Хотите добавить компьютер? (yes/no)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            shop.fillFromKeyboard();
            shop.displayComputers();
        }

        scanner.close();
    }


    private static Shop demonstrateComputerShop() {
        Shop shop = new Shop();


        Computer computer1 = new Computer(
                Brand.ASUS,
                new Processor("Intel i7", 3.5),
                new Memory(16, "DDR4"),
                new Monitor(15.6, "1920x1080"),
                1200.0
        );

        Computer computer2 = new Computer(
                Brand.APPLE,
                new Processor("M1", 3.2),
                new Memory(8, "LPDDR4"),
                new Monitor(13.3, "2560x1600"),
                1500.0
        );

        shop.addComputer(computer1);
        shop.addComputer(computer2);
        shop.displayComputers();

        // Поиск компьютера
        Computer found = shop.findComputerByBrand(Brand.ASUS);
        if (found != null) {
            System.out.println("Найден компьютер: " + found);
        }

        return shop;
    }


    private static void demonstrateUndoableStringBuilder() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("Hello");
        System.out.println("После append: " + usb);

        usb.append(" World");
        System.out.println("После append: " + usb);

        usb.undo();
        System.out.println("После undo: " + usb);
    }


    private static void demonstrateObservableStringBuilder() {
        ObservableStringBuilder osb = new ObservableStringBuilder();


        StringBuilderObserver observer = observable ->
                System.out.println("Строка изменена: " + observable.toString());

        osb.addObserver(observer);
        osb.append("Hello");
        osb.append(" Observable");
        osb.delete(0, 6);


        System.out.println("Финальная строка: " + osb);
    }
}