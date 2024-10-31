import salad.Salad;
import java.util.Scanner;
import Command.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Salad salad = new Salad();
        try {
            int result = 10 / 0; // Це викликає ArithmeticException
        } catch (ArithmeticException e) {
            logger.error("Виникла критична помилка: " + e.getMessage(), e);
        }
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
            logger.info("Користувач вибрав опцію: " + choice); // Логування вибору користувача

            switch (choice) {
                case 1:
                    System.out.println("Оберіть овоч:");
                    // Додавання логіки вибору овоча
                    Command addVegetable = new AddVegetableCommand(salad);
                    addVegetable.execute();
                    logger.info("Овоч додано до салату."); // Логування додавання овоча
                    break;

                case 2:
                    Command showSalad = new ShowSaladCommand(salad);
                    showSalad.execute();
                    logger.info("Салат показано."); // Логування показу салату
                    break;

                case 3:
                    Command calculateCalories = new CalculateCaloriesCommand(salad);
                    calculateCalories.execute();
                    logger.info("Підрахунок калорійності виконано."); // Логування підрахунку калорій
                    break;

                case 4:
                    Command sortByWeight = new SortByWeightCommand(salad);
                    sortByWeight.execute();
                    logger.info("Овочі відсортовано за вагою."); // Логування сортування
                    break;

                case 5:
                    Command findVegetables = new FindVegetablesRangeCommand(salad);
                    findVegetables.execute();
                    logger.info("Овочі знайдено за діапазоном калорій."); // Логування пошуку овочів
                    break;

                case 6:
                    Command saveSalad = new SaveSaladCommand(salad);
                    saveSalad.execute();
                    logger.info("Салат збережено в файл."); // Логування збереження салату
                    break;

                case 7:
                    Command loadSalad = new LoadSaladCommand(salad);
                    loadSalad.execute();
                    logger.info("Салат завантажено з файлу."); // Логування завантаження
                    break;

                case 8:
                    Command removeVegetable = new RemoveVegetableCommand(salad);
                    removeVegetable.execute();
                    logger.info("Овоч видалено із салату."); // Логування видалення овоча
                    break;

                case 9:
                    running = false;
                    logger.info("Програма завершена."); // Логування виходу з програми
                    break;

                default:
                    logger.warn("Неправильний вибір: " + choice); // Логування неправильного вибору
                    break;
            }
        }
        scanner.close();
    }
}
