// Файл: Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИЧЕСКАЯ РАБОТА №7 ===");
        System.out.println("=== Тестирование всех заданий ===\n");

        // Разделитель для красоты
        String separator = "=".repeat(50);

        // Задания 1-3: Movable
        System.out.println(separator);
        System.out.println("ЗАДАНИЯ 1-3: MovableRectangle и MovablePoint");
        System.out.println(separator);
        testMovable();

        // Задание 4: MathCalculable
        System.out.println("\n" + separator);
        System.out.println("ЗАДАНИЕ 4: MathCalculable и MathFunc");
        System.out.println(separator);
        testMathCalculable();

        // Задания 5-6: StringWork
        System.out.println("\n" + separator);
        System.out.println("ЗАДАНИЯ 5-6: StringWork и ProcessStrings");
        System.out.println(separator);
        testStringWork();

        // Задания 7-9: Printable
        System.out.println("\n" + separator);
        System.out.println("ЗАДАНИЯ 7-9: Printable, Book, Journal");
        System.out.println(separator);
        testPrintable();

        System.out.println("\n" + separator);
        System.out.println("ВСЕ ТЕСТЫ УСПЕШНО ВЫПОЛНЕНЫ!");
        System.out.println(separator);
    }

    // ==================== Методы тестирования ====================

    private static void testMovable() {
        // 1. Тестирование MovablePoint
        MovablePoint point1 = new MovablePoint(0, 0, 2, 3);
        MovablePoint point2 = new MovablePoint(5, 5, 2, 3);

        System.out.println("1. MovablePoint:");
        System.out.println("   Начальная позиция point1: " + point1);
        System.out.println("   Начальная позиция point2: " + point2);

        point1.moveRight();
        point1.moveDown();
        System.out.println("   point1 после moveRight() и moveDown(): " + point1);

        // 2. Тестирование speedTest()
        System.out.println("\n2. Проверка скорости (speedTest):");
        System.out.println("   point1 и point2 имеют одинаковую скорость? " + point1.speedTest(point2));

        // 3. Тестирование MovableRectangle
        MovableRectangle rect = new MovableRectangle(0, 0, 4, 3, 2, 2);
        System.out.println("\n3. MovableRectangle:");
        System.out.println("   Начальный прямоугольник: " + rect);
        System.out.println("   Проверка скорости точек прямоугольника: " + rect.speedTest());

        rect.moveUp();
        rect.moveRight();
        System.out.println("   После moveUp() и moveRight(): " + rect);
    }

    private static void testMathCalculable() {
        MathCalculable mc = new MathFunc();

        System.out.println("1. Возведение в степень:");
        System.out.println("   2^3 = " + mc.power(2, 3));
        System.out.println("   5^2 = " + mc.power(5, 2));

        System.out.println("\n2. Модуль комплексного числа:");
        System.out.println("   |3 + 4i| = " + mc.complexModulus(3, 4));
        System.out.println("   |1 + 1i| = " + mc.complexModulus(1, 1));

        System.out.println("\n3. Использование PI из интерфейса:");
        System.out.println("   Число PI = " + MathCalculable.PI);
        System.out.println("   Длина окружности (r=5) = " + ((MathFunc) mc).circleLength(5));
        System.out.println("   Длина окружности (r=10) = " + ((MathFunc) mc).circleLength(10));
    }

    private static void testStringWork() {
        StringWork sw = new ProcessStrings();
        String testString = "HelloWorld";
        String testString2 = "ИнтерфейсыВJava";

        System.out.println("Тестовая строка 1: \"" + testString + "\"");
        System.out.println("Тестовая строка 2: \"" + testString2 + "\"");

        System.out.println("\n1. Подсчет символов:");
        System.out.println("   Длина \"" + testString + "\": " + sw.countChars(testString));
        System.out.println("   Длина \"" + testString2 + "\": " + sw.countChars(testString2));

        System.out.println("\n2. Символы на нечетных позициях:");
        System.out.println("   Для \"" + testString + "\": \"" + sw.oddChars(testString) + "\"");
        System.out.println("   Для \"" + testString2 + "\": \"" + sw.oddChars(testString2) + "\"");

        System.out.println("\n3. Инверсия строки:");
        System.out.println("   \"" + testString + "\" -> \"" + sw.reverse(testString) + "\"");
        System.out.println("   \"" + testString2 + "\" -> \"" + sw.reverse(testString2) + "\"");
    }

    private static void testPrintable() {
        // Создаем массив Printable объектов
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой", 1863),
                new Journal("Хакер"),
                new Book("Отцы и дети", "И. Тургенев", 1862),
                new Journal("Компьютерра"),
                new Book("Преступление и наказание", "Ф. М. Достоевский", 1866)
        };

        System.out.println("1. Вывод всех объектов:");
        for (Printable p : items) {
            p.print();
        }

        System.out.println("\n2. Только книги (статический метод Book.printBooks()):");
        Book.printBooks(items);

        System.out.println("\n3. Только журналы (статический метод Journal.printMagazines()):");
        Journal.printMagazines(items);

        System.out.println("\n4. Проверка instanceof:");
        for (Printable p : items) {
            if (p instanceof Book) {
                System.out.println("   Книга: " + ((Book) p).getName());
            } else if (p instanceof Journal) {
                System.out.println("   Журнал: " + ((Journal) p).getName());
            }
        }
    }
}

// ==================== ИНТЕРФЕЙСЫ И КЛАССЫ ====================

// Интерфейс Movable для заданий 1-3
interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    private int x, y;
    private int xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    public boolean speedTest(MovablePoint other) {
        return this.xSpeed == other.xSpeed && this.ySpeed == other.ySpeed;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    public boolean speedTest() {
        return topLeft.speedTest(bottomRight);
    }

    @Override
    public String toString() {
        return "Rectangle[TopLeft=" + topLeft + ", BottomRight=" + bottomRight + "]";
    }
}

// Интерфейс MathCalculable для задания 4
interface MathCalculable {
    double PI = 3.141592653589793;

    double power(double base, double exponent);
    double complexModulus(double real, double imag);
}

class MathFunc implements MathCalculable {
    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double complexModulus(double real, double imag) {
        return Math.sqrt(real * real + imag * imag);
    }

    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}

// Интерфейс StringWork для заданий 5-6
interface StringWork {
    int countChars(String s);
    String oddChars(String s);
    String reverse(String s);
}

class ProcessStrings implements StringWork {
    @Override
    public int countChars(String s) {
        return s.length();
    }

    @Override
    public String oddChars(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

// Интерфейс Printable для заданий 7-9
interface Printable {
    void print();
}

class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году\n", name, author, year);
    }

    public static void printBooks(Printable[] printables) {
        for (Printable p : printables) {
            if (p instanceof Book) {
                p.print();
            }
        }
    }
}

class Journal implements Printable {
    private String name;

    public Journal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Журнал '%s'\n", name);
    }

    public static void printMagazines(Printable[] printables) {
        for (Printable p : printables) {
            if (p instanceof Journal) {
                p.print();
            }
        }
    }
}