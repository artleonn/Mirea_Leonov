import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student(101, "Иван", 4.2),
                new Student(103, "Мария", 4.8),
                new Student(100, "Петр", 3.9),
                new Student(102, "Анна", 4.5)
        };

        System.out.println("Исходный массив:");
        for (Student s : students) {
            System.out.println(s);
        }

        Sorting.insertionSort(students);
        System.out.println("\nПосле сортировки вставками по ID:");
        for (Student s : students) {
            System.out.println(s);
        }

        StudentComparatorByGPA gpaComparator = new StudentComparatorByGPA();
        Sorting.quickSort(students, 0, students.length - 1, gpaComparator);
        System.out.println("\nПосле быстрой сортировки по GPA (убывание):");
        for (Student s : students) {
            System.out.println(s);
        }

        List<Student> list1 = Arrays.asList(
                new Student(201, "Сергей", 4.0),
                new Student(203, "Ольга", 4.7)
        );
        List<Student> list2 = Arrays.asList(
                new Student(202, "Дмитрий", 3.8),
                new Student(200, "Елена", 4.9)
        );
        List<Student> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        mergedList = MergeSort.mergeSort(mergedList);
        System.out.println("\nПосле сортировки слиянием объединенного списка по ID:");
        for (Student s : mergedList) {
            System.out.println(s);
        }
    }
}