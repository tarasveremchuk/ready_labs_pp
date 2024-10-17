package Command;

import salad.Salad;

import java.io.IOException;
import java.util.Scanner;

public class LoadSaladCommand implements Command {
    private Salad salad;

    public LoadSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу для завантаження: ");
        String loadFilename = scanner.next();
        try {
            salad.loadFromFile(loadFilename);
            System.out.println("Салат завантажено з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні файлу: " + e.getMessage());
        }
    }
}
