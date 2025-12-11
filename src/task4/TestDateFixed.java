package task4;

public class TestDateFixed {
    public static void main(String[] args) {
        java.util.Date[] dates = new java.util.Date[10];

        // Инициализируем первый элемент
        dates[0] = new java.util.Date();

        System.out.println("dates[0]: " + dates[0]);
        System.out.println("dates[0].toString(): " + dates[0].toString());

        // Проверка остальных элементов (они null)
        System.out.println("\nОстальные элементы массива (null):");
        for (int i = 1; i < dates.length; i++) {
            System.out.println("dates[" + i + "]: " + dates[i]);
        }
    }
}