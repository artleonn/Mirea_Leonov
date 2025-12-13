package collections;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Элемент 1");
        list.add("Элемент 2");
        list.add("Элемент 3");

        System.out.println("Размер списка: " + list.size());

        list.add(1, "Новый элемент");

        System.out.println("Элемент по индексу 2: " + list.get(2));

        list.set(0, "Измененный элемент");

        System.out.println("Содержит 'Элемент 2'? " + list.contains("Элемент 2"));

        list.remove("Элемент 3");
        list.remove(0);

        for (String element : list) {
            System.out.println(element);
        }

        list.clear();
        System.out.println("Список пуст? " + list.isEmpty());
    }
}