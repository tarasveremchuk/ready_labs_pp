package vegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tomato extends Vegetable {
    private static final Logger logger = LogManager.getLogger(Tomato.class);
    private String variety; // Сорт помідора

    public Tomato(double weight, String variety) {
        super("Tomato", weight, 18);
        this.variety = variety;
        logger.info("Створено новий помідор: сорт = " + variety + ", вага = " + weight + "g");
    }

    public String getVariety() {
        return variety;
    }

    @Override
    public String toString() {
        String result = super.toString() + ", Сорт: " + variety;
        logger.debug("toString викликано: " + result);
        return result;
    }
}
