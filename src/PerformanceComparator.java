import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PerformanceComparator {
    private static final int DATA_SIZE = 100000;
    private static final int TEST_ITERATIONS = 1000;

    public void comparePerformance() {
        System.out.println("=== Сравнение производительности ArrayList и LinkedList ===");
        System.out.println("Размер тестовых данных: " + DATA_SIZE);
        System.out.println("Количество итераций для операций: " + TEST_ITERATIONS + "\n");

        // Создаем коллекции
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        // Заполняем коллекции
        System.out.println("1. Заполнение коллекций:");
        long startTime = System.nanoTime();
        for (int i = 0; i < DATA_SIZE; i++) {
            arrayList.add(i);
        }
        long arrayListFillTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < DATA_SIZE; i++) {
            linkedList.add(i);
        }
        long linkedListFillTime = System.nanoTime() - startTime;

        printResults("Заполнение", arrayListFillTime, linkedListFillTime);

        // Тестирование операции добавления в начало
        System.out.println("\n2. Добавление в начало:");
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            arrayList.add(0, i);
        }
        long arrayListAddFirstTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            linkedList.addFirst(i);
        }
        long linkedListAddFirstTime = System.nanoTime() - startTime;

        printResults("Добавление в начало", arrayListAddFirstTime, linkedListAddFirstTime);

        // Тестирование операции добавления в конец
        System.out.println("\n3. Добавление в конец:");
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            arrayList.add(i);
        }
        long arrayListAddLastTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            linkedList.addLast(i);
        }
        long linkedListAddLastTime = System.nanoTime() - startTime;

        printResults("Добавление в конец", arrayListAddLastTime, linkedListAddLastTime);

        // Тестирование операции вставки в середину
        System.out.println("\n4. Вставка в середину:");
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            arrayList.add(DATA_SIZE / 2, i);
        }
        long arrayListInsertMiddleTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            linkedList.add(DATA_SIZE / 2, i);
        }
        long linkedListInsertMiddleTime = System.nanoTime() - startTime;

        printResults("Вставка в середину", arrayListInsertMiddleTime, linkedListInsertMiddleTime);

        // Тестирование операции удаления из начала
        System.out.println("\n5. Удаление из начала:");
        startTime = System.nanoTime();
        for (int i = 0; i < Math.min(TEST_ITERATIONS, arrayList.size()); i++) {
            arrayList.remove(0);
        }
        long arrayListRemoveFirstTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < Math.min(TEST_ITERATIONS, linkedList.size()); i++) {
            linkedList.removeFirst();
        }
        long linkedListRemoveFirstTime = System.nanoTime() - startTime;

        printResults("Удаление из начала", arrayListRemoveFirstTime, linkedListRemoveFirstTime);

        // Тестирование операции поиска по значению
        System.out.println("\n6. Поиск элемента:");
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int searchValue = random.nextInt(DATA_SIZE);
            arrayList.contains(searchValue);
        }
        long arrayListSearchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int searchValue = random.nextInt(DATA_SIZE);
            linkedList.contains(searchValue);
        }
        long linkedListSearchTime = System.nanoTime() - startTime;

        printResults("Поиск элемента", arrayListSearchTime, linkedListSearchTime);

        // Тестирование операции получения по индексу
        System.out.println("\n7. Получение по индексу:");
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int index = random.nextInt(Math.min(DATA_SIZE, arrayList.size()));
            arrayList.get(index);
        }
        long arrayListGetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int index = random.nextInt(Math.min(DATA_SIZE, linkedList.size()));
            linkedList.get(index);
        }
        long linkedListGetTime = System.nanoTime() - startTime;

        printResults("Получение по индексу", arrayListGetTime, linkedListGetTime);
    }

    private void printResults(String operation, long arrayListTime, long linkedListTime) {
        System.out.printf("%-25s | ArrayList: %12.3f ms | LinkedList: %12.3f ms%n",
                operation,
                arrayListTime / 1_000_000.0,
                linkedListTime / 1_000_000.0);

        if (arrayListTime < linkedListTime) {
            double faster = (linkedListTime - arrayListTime) * 100.0 / linkedListTime;
            System.out.printf("  ArrayList быстрее на: %.2f%%%n", faster);
        } else {
            double faster = (arrayListTime - linkedListTime) * 100.0 / arrayListTime;
            System.out.printf("  LinkedList быстрее на: %.2f%%%n", faster);
        }
    }
}