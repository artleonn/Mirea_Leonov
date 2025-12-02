import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateCreator {
    private Scanner scanner;

    public DateCreator() {
        scanner = new Scanner(System.in);
    }

    public void createDateFromInput() {
        try {
            System.out.println("=== Создание Date и Calendar ===");

            // Ввод даты
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Введите число: ");
            int day = scanner.nextInt();

            // Ввод времени
            System.out.print("Введите часы (0-23): ");
            int hours = scanner.nextInt();

            System.out.print("Введите минуты (0-59): ");
            int minutes = scanner.nextInt();

            scanner.nextLine(); // Очистка буфера

            // Создание Date (устаревший способ, но по заданию)
            @SuppressWarnings("deprecation")
            Date date = new Date(year - 1900, month - 1, day, hours, minutes);

            // Создание Calendar (рекомендуемый способ)
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day, hours, minutes, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            System.out.println("\n=== Результаты ===");
            System.out.println("Созданный объект Date: " + date);
            System.out.println("Созданный объект Calendar: " + calendar.getTime());
            System.out.println("Calendar поля:");
            System.out.println("  Год: " + calendar.get(Calendar.YEAR));
            System.out.println("  Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("  День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("  Часы: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("  Минуты: " + calendar.get(Calendar.MINUTE));

        } catch (Exception e) {
            System.out.println("Ошибка при вводе данных: " + e.getMessage());
        }
    }

    public void close() {
        scanner.close();
    }
}
