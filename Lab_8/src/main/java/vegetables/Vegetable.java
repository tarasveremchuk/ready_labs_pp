package vegetables;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Vegetable {
    private static final Logger logger = LogManager.getLogger(Vegetable.class);
    private String name;
    private double weight;
    private double calories;

    public Vegetable(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        logger.info("Створено новий овоч: назва = " + name + ", вага = " + weight + "g, калорії = " + calories); // Логування створення овоча
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    // Метод для підрахунку загальних калорій для даного овоча
    public double calculateCalories() {
        double totalCalories = (weight / 100) * calories;
        logger.debug("Підрахунок калорій для " + name + ": " + totalCalories + " ккал"); // Логування підрахунку калорій
        return totalCalories;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        String result = "Vegetable{name='" + name + "', weight=" + weight + ", calories=" + (int) calories + "}";
        logger.debug("toString викликано: " + result); // Логування результату toString
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable vegetable = (Vegetable) o;
        boolean isEqual = Double.compare(vegetable.weight, weight) == 0 &&
                Double.compare(vegetable.calories, calories) == 0 &&
                Objects.equals(name, vegetable.name);
        logger.debug("Перевірка рівності для " + name + ": " + isEqual); // Логування перевірки рівності
        return isEqual;
    }
}
