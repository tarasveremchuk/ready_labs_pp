package vegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cabbage extends Vegetable {
    private static final Logger logger = LogManager.getLogger(Cabbage.class);
    private String type; // Тип капусти (наприклад, білокачанна, цвітна)

    public Cabbage(double weight, String type) {
        super("Cabbage", weight, 25);
        this.type = type;
        logger.info("Створено нову капусту: тип = " + type + ", вага = " + weight);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        String result = super.toString() + ", Тип: " + type;
        logger.debug("toString викликано: " + result);
        return result;
    }
}
