import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ДЕМОНСТРАЦИЯ ВСЕХ ЗАДАНИЙ ===\n");

        // Задание 1
        System.out.println("ЗАДАНИЕ 1: Информация о разработчике");
        DeveloperInfo developer = new DeveloperInfo("Леонов");
        developer.displayInfo();

        System.out.print("Нажмите Enter для отметки о сдаче задания...");
        scanner.nextLine();
        developer.submitAssignment();
        developer.displayInfo();
        developer.displayTimeInMillis();
        System.out.println();

        // Задание 2
        System.out.println("ЗАДАНИЕ 2: Сравнение дат");
        DateComparator comparator = new DateComparator();
        comparator.compareDates();
        System.out.println();

        // Задание 3
        System.out.println("ЗАДАНИЕ 3: Класс Student");
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 15); // 15 января 2000
        Student student = new Student("Иван", "Иванов", cal.getTime());

        System.out.println("Студент (по умолчанию): " + student);
        System.out.println("Дата рождения (SHORT): " + student.formatBirthDate("SHORT"));
        System.out.println("Дата рождения (MEDIUM): " + student.formatBirthDate("MEDIUM"));
        System.out.println("Дата рождения (LONG): " + student.formatBirthDate("LONG"));
        System.out.println("Дата рождения (FULL): " + student.formatBirthDate("FULL"));
        System.out.println();

        // Задание 4
        System.out.println("ЗАДАНИЕ 4: Создание Date и Calendar");
        DateCreator dateCreator = new DateCreator();
        dateCreator.createDateFromInput();
        System.out.println();

        // Задание 5
        System.out.println("ЗАДАНИЕ 5: Сравнение производительности");
        PerformanceComparator perfComparator = new PerformanceComparator();
        perfComparator.comparePerformance();

        scanner.close();
    }
}
