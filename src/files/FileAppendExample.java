package files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppendExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для добавления в конец файла:");
        String textToAppend = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write("\n" + textToAppend);
            writer.flush();
            System.out.println("Текст успешно добавлен в конец файла 'output.txt'");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}