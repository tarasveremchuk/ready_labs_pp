package Command;

import org.junit.jupiter.api.Test;
import salad.Salad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadSaladCommandTest {

    @Test
    public void testExecuteSuccessfulLoad() throws IOException {
        Salad salad = new Salad() {
            @Override
            public void loadFromFile(String filename) throws IOException {
                if (!filename.equals("valid.txt")) {
                    throw new IOException("Недійсне ім'я файлу");
                }
            }
        };

        LoadSaladCommand loadCommand = new LoadSaladCommand(salad);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new java.io.ByteArrayInputStream("valid.txt\n".getBytes()));

        loadCommand.execute();

        String output = outputStream.toString().trim();
        assertEquals("Введіть ім'я файлу для завантаження: Салат завантажено з файлу.", output);
    }

    @Test
    public void testExecuteLoadFileError() throws IOException {
        Salad salad = new Salad() {
            @Override
            public void loadFromFile(String filename) throws IOException {
                if (!filename.equals("valid.txt")) {
                    throw new IOException("Недійсне ім'я файлу");
                }
            }
        };

        LoadSaladCommand loadCommand = new LoadSaladCommand(salad);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new java.io.ByteArrayInputStream("invalid.txt\n".getBytes()));

        loadCommand.execute();

        String output = outputStream.toString().trim();
        assertEquals("Введіть ім'я файлу для завантаження: Помилка при завантаженні файлу: Недійсне ім'я файлу", output);
    }
}
