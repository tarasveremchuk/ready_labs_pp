package Command;

import salad.Salad;

public class CalculateCaloriesCommand implements Command {
    private Salad salad;

    public CalculateCaloriesCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        double totalCalories = salad.calculateTotalCalories();
        System.out.println("Загальна калорійність: " + totalCalories + " ккал");
    }
}
