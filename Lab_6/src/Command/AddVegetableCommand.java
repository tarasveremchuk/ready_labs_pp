package Command;

import salad.Salad;
import vegetables.*;
import java.util.Scanner;

public class AddVegetableCommand implements Command {
    private Salad salad;

    public AddVegetableCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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
            default:
                System.out.println("Невідомий овоч.");
                break;
        }
        System.out.println("Овоч додано до салату.");
    }
}
