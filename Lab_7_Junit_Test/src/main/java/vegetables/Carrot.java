package vegetables;

public class Carrot extends Vegetable {
    public String getState() {
        return state;
    }

    private String state;

    public Carrot(double weight, String state) {
        super("Carrot", weight, 41);
        this.state = state;
    }

    @Override
    public String toString() {
        return "Назва: " + getName() + ", Вага: " + getWeight() + "g, Калорії: " + (int)getCalories() + ", Стан: " + state;
    }

}
