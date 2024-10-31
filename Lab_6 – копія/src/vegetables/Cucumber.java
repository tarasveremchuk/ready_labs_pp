package vegetables;

public class Cucumber extends Vegetable {
    private double length;

    public Cucumber(double weight, double length) {
        super("Cucumber", weight, 16);
        this.length = length;
    }
    @Override
    public String toString() {
        return super.toString() + ", Довжина: " + length + " см";
    }
}
