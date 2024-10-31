package Command;import Command.SaveSaladCommand;
import salad.Salad;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveSaladCommandTest {

    @Test
    public void testExecuteSuccessfully() throws IOException {
        Salad salad = new Salad();
        SaveSaladCommand command = new SaveSaladCommand(salad);

        File tempFile = File.createTempFile("testSalad", ".txt");
        tempFile.deleteOnExit();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        System.setIn(new java.io.ByteArrayInputStream((tempFile.getName() + "\n").getBytes()));

        command.execute();

        assertTrue(tempFile.exists(), "The file should exist after saving.");
        assertTrue(outputStream.toString().contains("Салат збережено у файл."), "Success message not found in output.");
    }

    @Test
    public void testExecuteWithIOException() {
        Salad salad = new Salad() {
            @Override
            public void saveToFile(String filename) throws IOException {
                throw new IOException("Simulated error");
            }
        };
        SaveSaladCommand command = new SaveSaladCommand(salad);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        System.setIn(new java.io.ByteArrayInputStream("invalidFileName.txt\n".getBytes()));

        command.execute();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Помилка при збереженні файлу: Simulated error\n";

        assertTrue(actualOutput.contains(expectedOutput.trim()), "Expected error message not found in output.");

        System.setOut(originalOut);
    }
}
