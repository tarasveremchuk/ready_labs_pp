import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, Command> commands;
    private Scanner scanner;

    public Menu() {
        commands = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void displayMenu() {
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

    }

    public void executeCommand() {
        int choice = scanner.nextInt();
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неправильний вибір, спробуйте ще раз.");
        }
    }
}
