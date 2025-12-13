package collections;

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Первый");
        list.add("Второй");
        list.addLast("Третий");
        list.addFirst("Нулевой");

        System.out.println("Размер списка: " + list.size());

        System.out.println("Первый элемент: " + list.getFirst());
        System.out.println("Последний элемент: " + list.getLast());

        list.set(2, "Измененный второй");

        list.removeFirst();
        list.removeLast();

        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Содержит 'Первый'? " + list.contains("Первый"));
    }
}