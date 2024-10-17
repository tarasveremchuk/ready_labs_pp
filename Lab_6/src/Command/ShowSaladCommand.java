package Command;

import salad.Salad;

public class ShowSaladCommand implements Command {
    private Salad salad;

    public ShowSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.println(salad);
    }
}

