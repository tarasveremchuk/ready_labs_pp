package vegetables;

public class Cabbage extends Vegetable {
    private String type; // Тип капусти (наприклад, білокачанна, цвітна)

    public Cabbage(double weight, String type) {
        super("Cabbage", weight, 25);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Тип: " + type;
    }
}
