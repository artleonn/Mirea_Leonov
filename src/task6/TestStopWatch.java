package task6;

import java.util.Random;

public class TestStopWatch {
    public static void main(String[] args) {
        // Создаем массив из 100000 случайных чисел
        int[] numbers = new int[100000];
        Random random = new Random();

        System.out.println("Генерация массива из 100000 чисел...");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000000);
        }

        // Создаем секундомер
        StopWatch stopwatch = new StopWatch();

        // Сортируем массив методом выбора
        System.out.println("Начало сортировки методом выбора...");
        selectionSort(numbers);

        // Останавливаем секундомер
        stopwatch.stop();

        // Выводим результаты
        System.out.println("Сортировка завершена!");
        System.out.println("Затраченное время: " + stopwatch.getElapsedTime() + " мс");

        // Проверяем, что массив отсортирован
        System.out.println("\nПроверка сортировки (первые 10 элементов):");
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n... и последние 10 элементов:");
        for (int i = numbers.length - 10; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Меняем местами
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}