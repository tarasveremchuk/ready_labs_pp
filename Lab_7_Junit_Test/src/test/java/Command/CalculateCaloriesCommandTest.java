package Command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salad.Salad;
import vegetables.Carrot;
import vegetables.Tomato;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateCaloriesCommandTest {
    private Salad salad;
    private CalculateCaloriesCommand calculateCaloriesCommand;

    @BeforeEach
    void setUp() {
        salad = new Salad();
        calculateCaloriesCommand = new CalculateCaloriesCommand(salad);
    }

    @Test
    void testExecuteCalculatesTotalCalories() {
        // Додаємо овочі до салату
        salad.addVegetable(new Carrot(100, "Сира"));
        salad.addVegetable(new Tomato(150, "Сорт A"));

        // Загальна калорійність
        double expectedCalories = salad.calculateTotalCalories();

        calculateCaloriesCommand.execute();

        // Перевірка що калорійність обчислена правильно
        assertEquals(expectedCalories, salad.calculateTotalCalories(), 0.01);
    }

    @Test
    void testExecuteWithEmptySalad() {
        // Порожній салат
        double expectedCalories = salad.calculateTotalCalories();

        calculateCaloriesCommand.execute();

        // Перевірка калорійність для порожнього салату дорівнює 0
        assertEquals(expectedCalories, salad.calculateTotalCalories(), 0.01);
    }
    @Test
    void testExecuteWithMultipleVegetables() {
        // Додаємо кілька овочів до салату
        salad.addVegetable(new Carrot(100, "Сира"));
        salad.addVegetable(new Tomato(150, "Сорт A"));
        salad.addVegetable(new Carrot(200, "Сира"));

        // Загальна калорійність
        double expectedCalories = salad.calculateTotalCalories();

        calculateCaloriesCommand.execute();

        // Перевірка калорійність обчислена правильно
        assertEquals(expectedCalories, salad.calculateTotalCalories(), 0.01);
    }

}
