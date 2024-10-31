package Command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import salad.Salad;

import java.io.IOException;
import java.util.Scanner;

public class LoadSaladCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoadSaladCommand.class);
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
            logger.error("Помилка при завантаженні файлу: " + loadFilename, e);
        }
    }
}
