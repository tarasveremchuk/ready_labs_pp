package Command;

import salad.Salad;

import java.util.Scanner;

public class RemoveVegetableCommand implements Command {
    private Salad salad;

    public RemoveVegetableCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(salad);
        System.out.print("Введіть індекс овоча для видалення: ");
        int indexToRemove = scanner.nextInt();
        salad.removeVegetable(indexToRemove);
    }
}
