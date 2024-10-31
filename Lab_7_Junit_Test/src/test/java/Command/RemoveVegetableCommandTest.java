package Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salad.Salad;
import vegetables.Cucumber;
import vegetables.Tomato;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveVegetableCommandTest {
    private Salad salad;
    private RemoveVegetableCommand removeVegetableCommand;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        salad = new Salad();
        salad.addVegetable(new Tomato(100, "Cherry"));
        salad.addVegetable(new Cucumber(150, 20));
        removeVegetableCommand = new RemoveVegetableCommand(salad);
    }

    @Test
    public void testExecuteRemovesVegetable() {
        String input = "0\n"; // Індекс овоча для видалення
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        removeVegetableCommand.execute();

        // Перевірка, що овоч видалено
        assertFalse(salad.getVegetables().contains(new Tomato(100, "Cherry")));
        assertTrue(salad.getVegetables().contains(new Cucumber(150, 20)));


        String output = outputStream.toString();
        System.out.println("Фактичний вивід: " + output);
    }
}
