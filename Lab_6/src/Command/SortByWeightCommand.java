package Command;

import salad.Salad;

public class SortByWeightCommand implements Command {
    private Salad salad;

    public SortByWeightCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        salad.sortByWeight();
        System.out.println("Овочі відсортовані за вагою.");
    }
}
