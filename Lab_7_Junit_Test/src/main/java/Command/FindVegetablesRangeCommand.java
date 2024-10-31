package Command;
import salad.Salad;

import java.util.Scanner;

public class FindVegetablesRangeCommand implements Command {
    private Salad salad;

    public FindVegetablesRangeCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Мінімальні калорії: ");
        double minCalories = scanner.nextDouble();
        System.out.print("Максимальні калорії: ");
        double maxCalories = scanner.nextDouble();
        System.out.println("Знайдені овочі: " + salad.findVegetablesByCaloriesRange(minCalories, maxCalories));
    }
}

