public class PrintableTest {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой", 1863),
                new Journal("Хакер"),
                new Book("Отцы и дети", "И. Тургенев", 1862),
                new Journal("Компьютерра")
        };

        System.out.println("=== Книги ===");
        Book.printBooks(items);

        System.out.println("=== Журналы ===");
        Journal.printMagazines(items);
    }
}