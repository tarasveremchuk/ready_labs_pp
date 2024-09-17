import java.util.Scanner;

public class FibonacciCubesSimple {

    // Метод для обчислення N-го числа Фібоначчі
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Метод для перевірки, чи є число кубом
    public static boolean isCube(long num) {
        long cubeRoot = Math.round(Math.cbrt(num));
        return cubeRoot * cubeRoot * cubeRoot == num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості чисел Фібоначчі
        System.out.print("Введіть кількість чисел Фібоначчі: ");
        int n = scanner.nextInt();

        System.out.println("Числа Фібоначчі:");
        for (int i = 0; i < n; i++) {
            long fibNum = fibonacci(i);
            System.out.println(fibNum + (isCube(fibNum) ? " - є кубом" : ""));
        }
    }
}
