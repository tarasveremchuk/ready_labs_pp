package salad;
import vegetables.*;
import vegetables.Tomato;
import vegetables.Vegetable;
import java.io.*;
import java.util.*;
import java.util.spi.CalendarNameProvider;

public class Salad {
    private List<Vegetable> vegetables;

    public Salad() {
        this.vegetables = new ArrayList<>();
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public void removeVegetable(int index) {
        if (index >= 0 && index < vegetables.size()) {
            vegetables.remove(index);
        } else {
            System.out.println("Овоч з таким індексом не знайдено.");
        }
    }

    public double calculateTotalCalories() {
        double totalCalories = 0;
        for (Vegetable veg : vegetables) {
            totalCalories += veg.calculateCalories();
        }
        return totalCalories;
    }

    public void sortByWeight() {
        vegetables.sort(Comparator.comparing(Vegetable::getWeight));
    }

    public List<Vegetable> findVegetablesByCaloriesRange(double minCalories, double maxCalories) {
        List<Vegetable> foundVegetables = new ArrayList<>();
        for (Vegetable veg : vegetables) {
            double calories = veg.calculateCalories();
            if (calories >= minCalories && calories <= maxCalories) {
                foundVegetables.add(veg);
            }
        }
        return foundVegetables;
    }

    // Збереження овочів в файл
    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vegetable veg : vegetables) {
                writer.write(veg.getName() + "," + veg.getWeight() + "," + veg.calculateCalories());
                writer.newLine();
            }
        }
    }

    // Читання овочів з файлу
    public void loadFromFile(String filename) throws IOException {
        vegetables.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                double weight = Double.parseDouble(data[1]);
                double calories = Double.parseDouble(data[2]);

                switch (name.toLowerCase()) {
                    case "tomato":
                        // Передбачаємо, що вид томата є в даних
                        String tomatoType = data.length > 3 ? data[3] : "Cherry";
                        vegetables.add(new Tomato(weight, tomatoType));
                        break;

                    case "cucumber":
                        // Для огірків можемо використовувати параметр типу огірка
                        double cucumberLength = data.length > 3 ? Double.parseDouble(data[3]) : 15.0; // Параметр типу double
                        vegetables.add(new Cucumber(weight, cucumberLength));
                        break;

                    case "carrot":
                        String carrotState = data.length > 3 ? data[3] : "Сира";
                        vegetables.add(new Carrot(weight, carrotState));
                        break;

                    case "onion":
                        String onionColor = data.length > 3 ? data[3] : "Жовитй";
                        vegetables.add(new Onion(weight, onionColor));
                        break;

                    case "cabbage":
                        String cabbageType = data.length > 3 ? data[3] : "Білокачанна";
                        vegetables.add(new Cabbage(weight, cabbageType));
                        break;

                    default:
                        System.out.println("Невідомий овоч: " + name);
                }
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vegetables.size(); i++) {
            sb.append(i).append(". ").append(vegetables.get(i)).append("\n");
        }
        return sb.toString();
    }
}
