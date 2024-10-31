package vegetables;

public class Onion extends Vegetable {
    private String color;

    public Onion(double weight, String color) {
        super("Onion", weight, 40);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Колір: " + color;
    }
}
