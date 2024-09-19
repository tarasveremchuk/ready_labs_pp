import java.util.Scanner;

/**
 * Клас для представлення числа Фібоначчі
 */
class FibonacciNumber {
    /**
     * Значення числа Фібоначчі
     */
    int value;

    /**
     * Вказує, чи є це число кубом
     */
    boolean isCube;

    /**
     * Конструктор класу FibonacciNumber
     *
     * @param value  значення числа Фібоначчі
     * @param isCube чи є це число кубом
     */
    FibonacciNumber(int value, boolean isCube) {
        this.value = value;
        this.isCube = isCube;
    }
}

/**
 * Основний клас для генерації чисел Фібоначчі та перевірки, чи є вони кубами
 */
public class GFG {
    /**
     * Генерує масив об'єктів FibonacciNumber
     *
     * @param N кількість чисел Фібоначчі для генерації
     * @return масив об'єктів FibonacciNumber
     */
    static FibonacciNumber[] generateFibonacci(int N) {
        FibonacciNumber[] fibonacciNumbers = new FibonacciNumber[N]; // Масив об'єктів FibonacciNumber
        int num1 = 0, num2 = 1;

        for (int i = 0; i < N; i++) {
            /**
             * Створення об'єкту для кожного числа Фібоначчі
             */
            fibonacciNumbers[i] = new FibonacciNumber(num1, isCube(num1));

            /**
             * Перехід до наступного числа Фібоначчі
             */
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return fibonacciNumbers;
    }

    /**
     * Перевіряє, чи є задане число кубом
     *
     * @param n число для перевірки
     * @return true, якщо число є кубом, false інакше
     */
    static boolean isCube(int n) {
        int cubeRoot = (int) Math.round(Math.cbrt(n)); // Обчислення кубічного кореня
        return cubeRoot * cubeRoot * cubeRoot == n; // Перевірка, чи куб дорівнює початковому числу
    }

    /**
     * Основна функція програми
     * Запитує у користувача кількість чисел Фібоначчі для генерації,
     * виводить ці числа та вказує, чи є вони кубами
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Фібоначчі: ");
        int n = scanner.nextInt();

        /**
         * Виклик функції для створення масиву об'єктів FibonacciNumber
         */
        FibonacciNumber[] fibonacciNumbers = generateFibonacci(n);
        /**
         * Лічильник для чисел, які є кубами
         */
        int cubeCount = 0;

        /**
         * Вивід інформації
         */
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciNumbers[i].value);

            if (fibonacciNumbers[i].isCube) {
                System.out.println(" - куб");
                cubeCount++;
            } else {
                System.out.println();
            }
        }

        System.out.println("Всього чисел які є кубами: " + cubeCount);
    }
}
