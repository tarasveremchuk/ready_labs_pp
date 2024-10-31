import salad.Salad;
import java.util.Scanner;
import Command.*;
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
                    // Додавання логіки вибору овоча
                    Command addVegetable = new AddVegetableCommand(salad);
                    addVegetable.execute();
                    break;

                case 2:
                    Command showSalad = new ShowSaladCommand(salad);
                    showSalad.execute();
                    break;
                case 3:
                    Command calculateCalories = new CalculateCaloriesCommand(salad);
                    calculateCalories.execute();
                    break;
                case 4:
                    Command sortByWeight = new SortByWeightCommand(salad);
                    sortByWeight.execute();
                    break;
                case 5:
                    Command findVegetables = new FindVegetablesRangeCommand(salad);
                    findVegetables.execute();
                    break;
                case 6:
                    Command saveSalad = new SaveSaladCommand(salad);
                    saveSalad.execute();
                    break;
                case 7:
                    Command loadSalad = new LoadSaladCommand(salad);
                    loadSalad.execute();
                    break;
                case 8:
                    Command removeVegetable = new RemoveVegetableCommand(salad);
                    removeVegetable.execute();
                    break;
                case 9:
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
}
