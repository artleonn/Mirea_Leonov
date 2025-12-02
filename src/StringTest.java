public class StringTest {
    public static void main(String[] args) {
        StringWork sw = new ProcessStrings();
        String test = "HelloWorld";
        System.out.println("Длина: " + sw.countChars(test));
        System.out.println("Нечетные символы: " + sw.oddChars(test));
        System.out.println("Инверсия: " + sw.reverse(test));
    }
}