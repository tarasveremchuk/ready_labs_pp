package vegetables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TomatoTest {

    @Test
    public void testConstructorAndGetVariety() {
        double weight = 250.0;
        String variety = "Cherry";

        Tomato tomato = new Tomato(weight, variety);

        assertEquals(weight, tomato.getWeight(), "Вага помідора не відповідає очікуваній");
        assertEquals(variety, tomato.getVariety(), "Сорт помідора не відповідає очікуваному");
    }

    @Test
    public void testToString() {
        double weight = 250.0;
        String variety = "Cherry";

        Tomato tomato = new Tomato(weight, variety);

        String expectedOutput = "Vegetable{name='Tomato', weight=250.0, calories=18}, Сорт: Cherry";

        assertEquals(expectedOutput, tomato.toString(), "Вивід методу toString() не відповідає очікуваному");
    }
}
