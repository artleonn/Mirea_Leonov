package files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для записи в файл:");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            writer.write(text);
            writer.flush();
            System.out.println("Текст успешно записан в файл 'output.txt'");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}