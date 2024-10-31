package Command;

import Command.SortByWeightCommand;
import salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vegetables.Cucumber;
import vegetables.Tomato;
import vegetables.Vegetable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortByWeightCommandTest {

    private Salad salad;
    private SortByWeightCommand sortByWeightCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        salad = new Salad();

        salad.addVegetable(new Tomato(150, "Cherry")); // 150 г
        salad.addVegetable(new Cucumber(100, 15.0)); // 100 г
        salad.addVegetable(new Tomato(200, "Roma")); // 200 г

        sortByWeightCommand = new SortByWeightCommand(salad);

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecuteSortsSaladByWeight() {
        sortByWeightCommand.execute();

        String actualOutput = outputStream.toString().trim();

        String expectedOutput = "Овочі відсортовані за вагою.";

        // Перевірка, чи вивід відповідає очікуваному
        assertEquals(expectedOutput, actualOutput, "Вивід не відповідає очікуваному");

        // Перевірка, чи овочі відсортовані за вагою
        List<Vegetable> vegetables = salad.getVegetables();
        assertEquals(3, vegetables.size(), "Кількість овочів не відповідає очікуваному");

        assertEquals(100, vegetables.get(0).getWeight(), "Перший овоч повинен важити 100 г");
        assertEquals(150, vegetables.get(1).getWeight(), "Другий овоч повинен важити 150 г");
        assertEquals(200, vegetables.get(2).getWeight(), "Третій овоч повинен важити 200 г");
    }
}
