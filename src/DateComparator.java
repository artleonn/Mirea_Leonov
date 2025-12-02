import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateComparator {
    private Scanner scanner;

    public DateComparator() {
        scanner = new Scanner(System.in);
    }

    public void compareDates() {
        try {
            System.out.println("=== Сравнение дат ===");
            System.out.print("Введите дату (формат: dd.MM.yyyy): ");
            String inputDateStr = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date userDate = dateFormat.parse(inputDateStr);
            Date currentDate = new Date();

            System.out.println("\nТекущая дата: " + dateFormat.format(currentDate));
            System.out.println("Введенная дата: " + dateFormat.format(userDate));

            // Сравнение дат (без учета времени)
            SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyyMMdd");
            int currentDateInt = Integer.parseInt(dateOnlyFormat.format(currentDate));
            int userDateInt = Integer.parseInt(dateOnlyFormat.format(userDate));

            if (userDateInt == currentDateInt) {
                System.out.println("Даты совпадают!");
            } else if (userDateInt > currentDateInt) {
                System.out.println("Введенная дата БУДУЩАЯ");
            } else {
                System.out.println("Введенная дата ПРОШЕДШАЯ");
            }

            // Сравнение с учетом времени
            System.out.println("\n=== Сравнение с точностью до миллисекунд ===");
            System.out.println("Текущее время (мс): " + currentDate.getTime());
            System.out.println("Введенная дата (мс): " + userDate.getTime());

            if (userDate.getTime() == currentDate.getTime()) {
                System.out.println("Время совпадает!");
            } else if (userDate.getTime() > currentDate.getTime()) {
                System.out.println("Введенное время БУДУЩЕЕ");
            } else {
                System.out.println("Введенное время ПРОШЕДШЕЕ");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты!");
        }
    }

    public void close() {
        scanner.close();
    }
}
