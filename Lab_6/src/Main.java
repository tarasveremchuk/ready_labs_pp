import salad.Salad;
import vegetables.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salad salad = new Salad();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Додати овоч");
            System.out.println("2. Показати салат");
            System.out.println("3. Підрахувати калорійність");
            System.out.println("4. Сортувати овочі за вагою");
            System.out.println("5. Знайти овочі за діапазоном калорій");
            System.out.println("6. Зберегти салат в файл");
            System.out.println("7. Завантажити салат з файлу");
            System.out.println("8. Видалити овоч із салату");
            System.out.println("9. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Оберіть овоч:");
                    System.out.println("1 - Томат, 2 - Морква, 3 - Огірок, 4 - Капуста, 5 - Цибуля");
                    int vegChoice = scanner.nextInt();
                    switch (vegChoice) {
                        case 1:
                            System.out.print("Вага томату (г): ");
                            double tomatoWeight = scanner.nextDouble();
                            System.out.print("Сорт томату: ");
                            String variety = scanner.next();
                            salad.addVegetable(new Tomato(tomatoWeight, variety));
                            break;
                        case 2:
                            System.out.print("Вага моркви (г): ");
                            double carrotWeight = scanner.nextDouble();
                            System.out.print("Колір моркви: ");
                            String color = scanner.next();
                            salad.addVegetable(new Carrot(carrotWeight, color));
                            break;
                        case 3:
                            System.out.print("Вага огірка (г): ");
                            double cucumberWeight = scanner.nextDouble();
                            System.out.print("Довжина огірка (см): ");
                            double length = scanner.nextDouble();
                            salad.addVegetable(new Cucumber(cucumberWeight, length));
                            break;
                        case 4:
                            System.out.print("Вага капусти (г): ");
                            double cabbageWeight = scanner.nextDouble();
                            System.out.print("Тип капусти: ");
                            String type = scanner.next();
                            salad.addVegetable(new Cabbage(cabbageWeight, type));
                            break;
                        case 5:
                            System.out.print("Вага цибулі (г): ");
                            double onionWeight = scanner.nextDouble();
                            System.out.print("Гострота цибулі: ");
                            String sharpness = scanner.next();
                            salad.addVegetable(new Onion(onionWeight, sharpness));
                            break;
                    }
                    break;
                case 2:
                    System.out.println(salad);
                    break;
                case 3:
                    System.out.println("Загальна калорійність: " + salad.calculateTotalCalories() + " ккал");
                    break;
                case 4:
                    salad.sortByWeight();
                    System.out.println("Овочі відсортовані за вагою.");
                    break;
                case 5:
                    System.out.print("Мінімальні калорії: ");
                    double minCalories = scanner.nextDouble();
                    System.out.print("Максимальні калорії: ");
                    double maxCalories = scanner.nextDouble();
                    System.out.println("Знайдені овочі: " + salad.findVegetablesByCaloriesRange(minCalories, maxCalories));
                    break;
                case 6:
                    System.out.print("Введіть ім'я файлу для збереження: ");
                    String saveFilename = scanner.next();
                    try {
                        salad.saveToFile(saveFilename);
                        System.out.println("Салат збережено у файл.");
                    } catch (IOException e) {
                        System.out.println("Помилка при збереженні файлу: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Введіть ім'я файлу для завантаження: ");
                    String loadFilename = scanner.next();
                    try {
                        salad.loadFromFile(loadFilename);
                        System.out.println("Салат завантажено з файлу.");
                    } catch (IOException e) {
                        System.out.println("Помилка при завантаженні файлу: " + e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println(salad);
                    System.out.print("Введіть індекс овоча для видалення: ");
                    int indexToRemove = scanner.nextInt();
                    salad.removeVegetable(indexToRemove);
                    break;
                case 9:
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
}
