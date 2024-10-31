package vegetables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabbageTest {

    @Test
    public void testCabbageToString() {
        Cabbage cabbage = new Cabbage(1.0, "Білокачанна");
        String expected = "Vegetable{name='Cabbage', weight=1.0, calories=25}, Тип: Білокачанна";
        assertEquals(expected, cabbage.toString());
    }

    @Test
    public void testCabbageConstructor() {
        Cabbage cabbage = new Cabbage(1.5, "Цвітна");
        assertEquals("Цвітна", cabbage.getType());
    }

    @Test
    public void testGetType() {
        Cabbage cabbage = new Cabbage(2.0, "Пекінська");
        assertEquals("Пекінська", cabbage.getType());
    }
}
