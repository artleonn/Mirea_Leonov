public class MathTest {
    public static void main(String[] args) {
        MathCalculable mc = new MathFunc();
        System.out.println("2^3 = " + mc.power(2, 3));
        System.out.println("|3+4i| = " + mc.complexModulus(3, 4));
        System.out.println("Длина окружности (r=5) = " + ((MathFunc) mc).circleLength(5));
    }
}