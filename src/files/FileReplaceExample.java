package files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReplaceExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите новый текст для полной замены содержимого файла:");
        String newText = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            writer.write(newText);
            writer.flush();
            System.out.println("Содержимое файла 'output.txt' полностью заменено");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл: " + ex.getMessage());
        }

        scanner.close();
    }
}