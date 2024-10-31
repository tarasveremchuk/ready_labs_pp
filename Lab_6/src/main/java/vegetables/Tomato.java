package vegetables;

public class Tomato extends Vegetable {
    private String variety;

    public Tomato(double weight, String variety) {
        super("Tomato", weight, 18);
        this.variety = variety;
    }
    @Override
    public String toString() {
        return super.toString() + ", Сорт: " + variety;
    }
}
