package vegetables;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarrotTest {

    @Test
    public void testCarrotCreation() {
        Carrot carrot = new Carrot(150.0, "Fresh");
        assertNotNull(carrot);
        assertEquals(150.0, carrot.getWeight());
        assertEquals("Fresh", carrot.getState());
    }

    @Test
    public void testCarrotToString() {
        Carrot carrot = new Carrot(100.0, "Wilted");
        String expectedString = "Назва: Carrot, Вага: 100.0g, Калорії: 41, Стан: Wilted";
        assertEquals(expectedString, carrot.toString());
    }

    @Test
    public void testStateGetter() {
        Carrot carrot = new Carrot(200.0, "Fresh");
        assertEquals("Fresh", carrot.getState());
    }
}

