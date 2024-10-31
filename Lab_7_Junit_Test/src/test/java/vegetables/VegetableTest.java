package vegetables;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VegetableTest {

    @Test
    public void testVegetableCreation() {
        Vegetable vegetable = new Vegetable("Carrot", 200.0, 41.0) {
        };

        assertNotNull(vegetable);
        assertEquals("Carrot", vegetable.getName());
        assertEquals(200.0, vegetable.getWeight());
        assertEquals(41.0, vegetable.getCalories());
    }

    @Test
    public void testCalculateCalories() {
        Vegetable vegetable = new Vegetable("Carrot", 200.0, 41.0) {
        };
        double expectedCalories = (200.0 / 100) * 41.0; // 82.0
        assertEquals(expectedCalories, vegetable.calculateCalories());
    }

    @Test
    public void testToString() {
        Vegetable vegetable = new Vegetable("Carrot", 100.0, 41.0) {
        };
        String expectedString = "Vegetable{name='Carrot', weight=100.0, calories=41}";
        assertEquals(expectedString, vegetable.toString());
    }

    @Test
    public void testEquals() {
        Vegetable vegetable1 = new Vegetable("Carrot", 100.0, 41.0) {};
        Vegetable vegetable2 = new Vegetable("Carrot", 100.0, 41.0) {};
        Vegetable vegetable3 = new Vegetable("Potato", 150.0, 77.0) {};

        assertEquals(vegetable1, vegetable2);
        assertNotEquals(vegetable1, vegetable3);
    }

    @Test
    public void testEqualsDifferentWeight() {
        Vegetable vegetable1 = new Vegetable("Carrot", 100.0, 41.0) {};
        Vegetable vegetable2 = new Vegetable("Carrot", 150.0, 41.0) {};

        assertNotEquals(vegetable1, vegetable2);
    }

    @Test
    public void testEqualsDifferentCalories() {
        Vegetable vegetable1 = new Vegetable("Carrot", 100.0, 41.0) {};
        Vegetable vegetable2 = new Vegetable("Carrot", 100.0, 50.0) {};

        assertNotEquals(vegetable1, vegetable2);
    }

    @Test
    public void testEqualsDifferentName() {
        Vegetable vegetable1 = new Vegetable("Carrot", 100.0, 41.0) {};
        Vegetable vegetable2 = new Vegetable("Cabbage", 100.0, 41.0) {};

        assertNotEquals(vegetable1, vegetable2);
    }

    @Test
    public void testEqualsSameReference() {
        Vegetable vegetable = new Vegetable("Carrot", 100.0, 41.0) {};
        assertEquals(vegetable, vegetable);
    }

    @Test
    public void testEqualsNull() {
        Vegetable vegetable = new Vegetable("Carrot", 100.0, 41.0) {};
        assertNotEquals(vegetable, null);
    }
}
