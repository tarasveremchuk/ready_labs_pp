package Command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import salad.Salad;

import java.io.IOException;
import java.util.Scanner;

public class SaveSaladCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SaveSaladCommand.class);
    private Salad salad;

    public SaveSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу для збереження: ");
        String saveFilename = scanner.next();

        try {
            salad.saveToFile(saveFilename);
            System.out.println("Салат збережено у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні файлу: " + e.getMessage());
            logger.error("Помилка при збереженні файлу: " + saveFilename, e);
        }
    }
}
