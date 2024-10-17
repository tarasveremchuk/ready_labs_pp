public class Main {
    public static void main(String[] args) {
        // Створюємо меню
        Menu menu = new Menu();

        // Додаємо команди до меню
        menu.addCommand(1, new AddVegetableCommand());
        menu.addCommand(2, new ShowSaladCommand());
        menu.addCommand(3, new CalculateCalority());
        menu.addCommand(4, new SortingVegetables());
        menu.addCommand(5, new VegetablesByRange());
        menu.addCommand(6, new SaveToFile());
        menu.addCommand(7, new LoadFromFile());
        menu.addCommand(8, new DeleteVegetable());
        menu.addCommand(9, new ExitCommand());
        boolean running = true;
        while (running) {
            menu.displayMenu();
            menu.executeCommand();
        }
    }
}
