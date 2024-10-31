package vegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Carrot extends Vegetable {
    private static final Logger logger = LogManager.getLogger(Carrot.class);
    private String state; // Стан моркви (наприклад, свіжий, зіпсований)

    public Carrot(double weight, String state) {
        super("Carrot", weight, 41);
        this.state = state;
        logger.info("Створено нову моркву: стан = " + state + ", вага = " + weight);
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        String result = "Назва: " + getName() + ", Вага: " + getWeight() + "g, Калорії: " + (int)getCalories() + ", Стан: " + state;
        logger.debug("toString викликано: " + result);
        return result;
    }
}
