import java.util.Scanner;
import collections.*;
import files.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание для запуска:");
        System.out.println("1. Тестирование ArrayList");
        System.out.println("2. Тестирование LinkedList");
        System.out.println("3. Создание своей коллекции (CustomArrayList)");
        System.out.println("4. Запись в файл");
        System.out.println("5. Чтение из файла");
        System.out.println("6. Замена информации в файле");
        System.out.println("7. Добавление в конец файла");

        System.out.print("Введите номер задания (1-7): ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                TestArrayList.main(null);
                break;
            case 2:
                TestLinkedList.main(null);
                break;
            case 3:
                System.out.println("Задание 3 (CustomArrayList) - код представлен в соответствующем файле");
                break;
            case 4:
                FileWriteExample.main(null);
                break;
            case 5:
                FileReadExample.main(null);
                break;
            case 6:
                FileReplaceExample.main(null);
                break;
            case 7:
                FileAppendExample.main(null);
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }
}