package vegetables;

public class Carrot extends Vegetable {
    private String state;

    public Carrot(double weight, String state) {
        super("Carrot", weight, 41);
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString() + ", Стан: " + state;
    }
}
