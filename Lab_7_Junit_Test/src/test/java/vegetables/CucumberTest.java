package vegetables;

import vegetables.Cucumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTest {

    @Test
    public void testConstructorAndGetLength() {
        // Параметри для створення об'єкта
        double weight = 150.0;
        double length = 20.5;

        // Створення об'єкта Cucumber
        Cucumber cucumber = new Cucumber(weight, length);

        // Перевірка, чи правильні значення ваги та довжини
        assertEquals(weight, cucumber.getWeight(), "Вага огірка не відповідає очікуваній");
        assertEquals(length, cucumber.getLength(), "Довжина огірка не відповідає очікуваній");
    }

    @Test
    public void testToString() {
        // Параметри для створення об'єкта
        double weight = 150.0;
        double length = 20.0;

        // Створення об'єкта Cucumber
        Cucumber cucumber = new Cucumber(weight, length);

        // Ожидаємий вивід
        String expectedOutput = "Vegetable{name='Cucumber', weight=150.0, calories=16}, Довжина: 20.0 см";

        // Перевірка, чи метод toString() повертає правильний рядок
        assertEquals(expectedOutput, cucumber.toString(), "Вивід методу toString() не відповідає очікуваному");
    }
}