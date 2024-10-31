package vegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Onion extends Vegetable {
    private static final Logger logger = LogManager.getLogger(Onion.class);
    private String color; // Колір цибулі

    public Onion(double weight, String color) {
        super("Onion", weight, 40);
        this.color = color;
        logger.info("Створено нову цибулю: колір = " + color + ", вага = " + weight + "g");
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        String result = super.toString() + ", Колір: " + color;
        logger.debug("toString викликано: " + result);
        return result;
    }
}
