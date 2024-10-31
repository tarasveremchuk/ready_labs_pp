package vegetables;

import java.util.Objects;

public abstract class Vegetable {
    private String name;
    private double weight;
    private double calories;

    public Vegetable(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
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
        return (weight / 100) * calories;
    }

    @Override
    public String toString() {
        return name + " [Вага: " + weight + "г, Калорії: " + calculateCalories() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.weight, weight) == 0 &&
                Double.compare(vegetable.calories, calories) == 0 &&
                Objects.equals(name, vegetable.name);
    }


}
