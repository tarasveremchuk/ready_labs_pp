import java.util.Scanner;

// Клас, що описує числову послідовність Фібоначчі
class FibonacciSequence {

    // Метод для обчислення N-го числа Фібоначчі
    public long getFibonacciNumber(int n) {
        if (n <= 1) {
            return n; // Повертаємо саме n, оскільки 0-й і 1-й числа — це 0 та 1 відповідно
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
    public boolean isCube(long num) {
        long cubeRoot = Math.round(Math.cbrt(num)); // Знаходимо кубічний корінь з числа
        return cubeRoot * cubeRoot * cubeRoot == num; // Перевіряємо, чи є це точним кубом
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FibonacciSequence fibonacci = new FibonacciSequence(); // Створюємо об'єкт класу FibonacciSequence

        // Введення кількості чисел Фібоначчі
        System.out.print("Введіть кількість чисел Фібоначчі: ");
        int n = scanner.nextInt(); // Користувач вводить кількість чисел, які потрібно обчислити

        System.out.println("Числа Фібоначчі:");
        for (int i = 0; i < n; i++) {
            long fibNum = fibonacci.getFibonacciNumber(i); // Отримуємо i-те число Фібоначчі
            System.out.println(fibNum + (fibonacci.isCube(fibNum) ? " - є кубом" : "")); // Виводимо число та, якщо воно є кубом, додаємо коментар
        }
    }
}
