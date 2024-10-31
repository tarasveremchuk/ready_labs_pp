package salad;

import vegetables.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables;
    private static final Logger logger = LogManager.getLogger(Salad.class);

    public Salad() {
        this.vegetables = new ArrayList<>();
        logger.info("Створено новий об'єкт салату.");
    }

    public void addVegetable(Vegetable vegetable) {
        if (vegetable != null) {
            vegetables.add(vegetable);
            logger.info("Додано овоч: " + vegetable.getName());
        } else {
            logger.error("Не вдалося додати овоч: овоч не може бути null");
            throw new IllegalArgumentException("Овоч не може бути null");
        }
    }

    public void removeVegetable(int index) {
        if (index < 0 || index >= vegetables.size()) {
            logger.error("Не вдалося видалити овоч: індекс поза межами.");
            throw new IndexOutOfBoundsException("Овоч з таким індексом не знайдено.");
        }
        Vegetable removedVegetable = vegetables.remove(index);
        logger.info("Видалено овоч: " + removedVegetable.getName());
    }

    public double calculateTotalCalories() {
        double totalCalories = vegetables.stream().mapToDouble(Vegetable::calculateCalories).sum();
        logger.info("Підрахунок загальної калорійності: " + totalCalories);
        return totalCalories;
    }

    public List<Vegetable> getVegetables() {
        logger.info("Отримано список овочів.");
        return new ArrayList<>(vegetables);
    }

    public void sortByWeight() {
        vegetables.sort(Comparator.comparing(Vegetable::getWeight));
        logger.info("Овочі відсортовано за вагою.");
    }

    public List<Vegetable> findVegetablesByCaloriesRange(double minCalories, double maxCalories) {
        List<Vegetable> foundVegetables = new ArrayList<>();
        for (Vegetable veg : vegetables) {
            double calories = veg.calculateCalories();
            if (calories >= minCalories && calories <= maxCalories) {
                foundVegetables.add(veg);
            }
        }
        logger.info("Знайдено овочів у діапазоні калорій: " + foundVegetables.size());
        return foundVegetables;
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vegetable veg : vegetables) {
                writer.write(veg.getName() + "," + veg.getWeight() + "," + veg.calculateCalories());
                writer.newLine();
            }
            logger.info("Салат збережено у файл: " + filename);
        } catch (IOException e) {
            logger.error("Не вдалося зберегти салат у файл: " + filename, e);
            throw e;
        }
    }

    public void loadFromFile(String filename) throws IOException {
        vegetables.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double weight = Double.parseDouble(data[1]);
                double calories = Double.parseDouble(data[2]);
                addVegetableFromData(name, weight, calories, data);
            }
            logger.info("Салат завантажено з файлу: " + filename);
        } catch (IOException e) {
            logger.error("Не вдалося завантажити салат з файлу: " + filename, e);
            throw e;
        }
    }

    private void addVegetableFromData(String name, double weight, double calories, String[] data) {
        Vegetable vegetable = null;
        switch (name.toLowerCase()) {
            case "tomato":
                String tomatoType = data.length > 3 ? data[3] : "Cherry";
                vegetable = new Tomato(weight, tomatoType);
                break;
            case "cucumber":
                double cucumberLength = data.length > 3 ? Double.parseDouble(data[3]) : 15.0;
                vegetable = new Cucumber(weight, cucumberLength);
                break;
            case "carrot":
                String carrotState = data.length > 3 ? data[3] : "Сира";
                vegetable = new Carrot(weight, carrotState);
                break;
            case "onion":
                String onionColor = data.length > 3 ? data[3] : "Жовтий";
                vegetable = new Onion(weight, onionColor);
                break;
            case "cabbage":
                String cabbageType = data.length > 3 ? data[3] : "Білокачанна";
                vegetable = new Cabbage(weight, cabbageType);
                break;
            default:
                logger.warn("Невідомий овоч: " + name);
                return;
        }
        vegetables.add(vegetable);
        logger.info("Додано овоч з даних: " + vegetable.getName());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Vegetable> vegetables = getVegetables();
        for (int i = 0; i < vegetables.size(); i++) {
            result.append(i).append(". ").append(vegetables.get(i).toString()).append("\n");
        }
        logger.info("Показано список овочів.");
        return result.toString();
    }
}
