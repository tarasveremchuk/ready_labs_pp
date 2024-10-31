package Command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import salad.Salad;
import vegetables.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AddVegetableCommandTest {
    private Salad salad;
    private AddVegetableCommand addVegetableCommand;

    @BeforeEach
    void setUp() {
        salad = new Salad();
        addVegetableCommand = new AddVegetableCommand(salad);
    }

    @Test
    void testExecuteTomato() {
        String userInput = "1\n100\nCherry\n"; // Вибір томату, вага 100 г, сорт Cherry
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().get(0) instanceof Tomato);
        Tomato tomato = (Tomato) salad.getVegetables().get(0);
        assertEquals(100, tomato.getWeight());
        assertEquals("Cherry", tomato.getVariety());
    }

    @Test
    void testExecuteCarrot() {
        String userInput = "2\n150\nOrange\n";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().get(0) instanceof Carrot);
        Carrot carrot = (Carrot) salad.getVegetables().get(0);
        assertEquals(150, carrot.getWeight());
        assertEquals("Orange", carrot.getState());
    }

    @Test
    void testExecuteCucumber() {
        String userInput = "3\n200\n25\n"; // Вибір огірка, вага 200 г, довжина 25 см
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().get(0) instanceof Cucumber);
        Cucumber cucumber = (Cucumber) salad.getVegetables().get(0);
        assertEquals(200, cucumber.getWeight());
        assertEquals(25, cucumber.getLength());
    }

    @Test
    void testExecuteCabbage() {
        String userInput = "4\n300\nGreen\n"; // Вибір капусти, вага 300 г, тип Green
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().get(0) instanceof Cabbage);
        Cabbage cabbage = (Cabbage) salad.getVegetables().get(0);
        assertEquals(300, cabbage.getWeight());
        assertEquals("Green", cabbage.getType());
    }

    @Test
    void testExecuteOnion() {
        String userInput = "5\n50\nSpicy\n"; // Вибір цибулі, вага 50 г, гострота Spicy
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().get(0) instanceof Onion);
        Onion onion = (Onion) salad.getVegetables().get(0);
        assertEquals(50, onion.getWeight());
        assertEquals("Spicy", onion.getColor());
    }

    @Test
    void testExecuteUnknownVegetable() {
        String userInput = "6\n"; // Невідомий овоч
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        assertEquals(0, salad.getVegetables().size());
    }
}
