public class Task3_AToB {
    public static void printFromAToB(int a, int b) {
        if (a == b) {
            System.out.print(a + " ");
            System.out.println();
            return;
        }

        System.out.print(a + " ");

        if (a < b) {
            printFromAToB(a + 1, b);
        } else {
            printFromAToB(a - 1, b);
        }
    }
}