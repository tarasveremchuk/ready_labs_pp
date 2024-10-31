package Command;
import Command.ShowSaladCommand;
import salad.Salad;
import Command.ShowSaladCommand;
import salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vegetables.Cucumber;
import vegetables.Tomato;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowSaladCommandTest {

    private Salad salad;
    private ShowSaladCommand showSaladCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        salad = new Salad();

        salad.addVegetable(new Tomato(100, "Cherry"));
        salad.addVegetable(new Cucumber(150, 15.0));

        showSaladCommand = new ShowSaladCommand(salad);

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecuteShowsCorrectSalad() {
        showSaladCommand.execute();

        String actualOutput = outputStream.toString().trim();

        String expectedOutput = "0. Vegetable{name='Tomato', weight=100.0, calories=18}, Сорт: Cherry\n" +
                "1. Vegetable{name='Cucumber', weight=150.0, calories=16}, Довжина: 15.0 см";

        assertEquals(expectedOutput, actualOutput, "Вивід не відповідає очікуваному");
    }


}
