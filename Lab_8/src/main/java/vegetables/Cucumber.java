package vegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cucumber extends Vegetable {
    private static final Logger logger = LogManager.getLogger(Cucumber.class);
    private double length; // Довжина огірка

    public Cucumber(double weight, double length) {
        super("Cucumber", weight, 16);
        this.length = length;
        logger.info("Створено новий огірок: вага = " + weight + "g, довжина = " + length + " см");
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        String result = super.toString() + ", Довжина: " + length + " см";
        logger.debug("toString викликано: " + result);
        return result;
    }
}
