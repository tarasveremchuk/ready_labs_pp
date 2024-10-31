package Command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salad.Salad;
import vegetables.Carrot;
import vegetables.Tomato;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FindVegetablesRangeCommandTest {
    private Salad salad;
    private FindVegetablesRangeCommand findVegetablesRangeCommand;

    @BeforeEach
    void setUp() {
        salad = new Salad();
        findVegetablesRangeCommand = new FindVegetablesRangeCommand(salad);

        salad.addVegetable(new Tomato(150.0, "Cherry"));
        salad.addVegetable(new Carrot(100.0, "Сира"));
    }

    @Test
    void testFindVegetablesInCaloriesRange() {
        //Ввід: мінімальні калорії 20, максимальні 50
        String input = "20\n50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        findVegetablesRangeCommand.execute();

        // Перевіряємо, чи знайдено овочі в заданому діапазоні
        assertTrue(salad.findVegetablesByCaloriesRange(20, 50).size() > 0);
    }
}
