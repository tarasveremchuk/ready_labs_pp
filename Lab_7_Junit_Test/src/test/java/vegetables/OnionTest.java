package vegetables;

import vegetables.Onion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnionTest {

    @Test
    public void testConstructorAndGetColor() {
        double weight = 200.0;
        String color = "Червоний";

        Onion onion = new Onion(weight, color);

        assertEquals(weight, onion.getWeight(), "Вага цибулі не відповідає очікуваній");
        assertEquals(color, onion.getColor(), "Колір цибулі не відповідає очікуваному");
    }

    @Test
    public void testToString() {
        double weight = 200.0;
        String color = "Червоний";

        Onion onion = new Onion(weight, color);

        String expectedOutput = "Vegetable{name='Onion', weight=200.0, calories=40}, Колір: Червоний";

        assertEquals(expectedOutput, onion.toString(), "Вивід методу toString() не відповідає очікуваному");
    }
}
