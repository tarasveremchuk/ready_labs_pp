package salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vegetables.*;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaladTest {

    private Salad salad;
    private Tomato tomato;
    private Cucumber cucumber;
    private Carrot carrot;

    @BeforeEach
    void setUp() {
        salad = new Salad();
        tomato = new Tomato(150.0, "Cherry");
        cucumber = new Cucumber(200.0, 20.0);
        carrot = new Carrot(100.0, "Сира");
    }

    @Test
    void testAddVegetable() {
        salad.addVegetable(tomato);
        assertEquals(1, salad.getVegetables().size());
        assertEquals(tomato, salad.getVegetables().get(0));
    }

    @Test
    void testAddNullVegetable() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> salad.addVegetable(null));
        assertEquals("Овоч не може бути null", exception.getMessage());
    }

    @Test
    void testRemoveVegetable() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        assertEquals(2, salad.getVegetables().size());

        salad.removeVegetable(0);
        assertEquals(1, salad.getVegetables().size());
        assertEquals(cucumber, salad.getVegetables().get(0));
    }

    @Test
    void testRemoveVegetableInvalidIndex() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> salad.removeVegetable(3));
        assertEquals("Овоч з таким індексом не знайдено.", exception.getMessage());
    }

    @Test
    void testCalculateTotalCalories() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        double totalCalories = salad.calculateTotalCalories();
        assertEquals(tomato.calculateCalories() + cucumber.calculateCalories(), totalCalories);
    }

    @Test
    void testSortByWeight() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        salad.sortByWeight();

        List<Vegetable> sortedVegetables = salad.getVegetables();
        assertEquals(carrot.getWeight(), sortedVegetables.get(0).getWeight());
        assertEquals(tomato.getWeight(), sortedVegetables.get(1).getWeight());
        assertEquals(cucumber.getWeight(), sortedVegetables.get(2).getWeight());
    }

    @Test
    void testFindVegetablesByCaloriesRange() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        double minCalories = 20.0;
        double maxCalories = 30.0;

        List<Vegetable> result = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        assertTrue(result.contains(tomato) || result.contains(cucumber));
        assertFalse(result.contains(carrot));

        result = salad.findVegetablesByCaloriesRange(0, 10);
        assertTrue(result.isEmpty());

        result = salad.findVegetablesByCaloriesRange(0, tomato.calculateCalories() + 1);
        assertTrue(result.contains(tomato));

        result = salad.findVegetablesByCaloriesRange(tomato.calculateCalories(), tomato.calculateCalories());
        assertTrue(result.contains(tomato));

        result = salad.findVegetablesByCaloriesRange(1000, 2000);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSaveToFile() throws IOException {
        salad.addVegetable(tomato);
        String filename = "test_vegetables.txt";
        salad.saveToFile(filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            assertEquals("Tomato,150.0," + tomato.calculateCalories(), line);
        }

        new File(filename).delete();
    }

    @Test
    void testLoadFromFile() throws IOException {
        String filename = "test_load_vegetables.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("tomato,150.0," + tomato.calculateCalories() + ",Cherry");
            writer.newLine();
            writer.write("cucumber,200.0," + cucumber.calculateCalories() + ",20.0");
            writer.newLine();
            writer.write("carrot,100.0," + carrot.calculateCalories() + ",Сира");
            writer.newLine();
        }

        salad.loadFromFile(filename);
        assertEquals(3, salad.getVegetables().size());

        new File(filename).delete();
    }

    @Test
    void testLoadFromFileWithUnknownVegetable() throws IOException {
        String filename = "test_load_unknown_vegetables.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("unknown_vegetable,150.0,30.0");
            writer.newLine();
            writer.write("tomato,150.0," + tomato.calculateCalories() + ",Cherry");
            writer.newLine();
        }

        salad.loadFromFile(filename);
        assertEquals(1, salad.getVegetables().size());
        assertEquals(tomato, salad.getVegetables().get(0));

        new File(filename).delete();
    }

    @Test
    void testLoadFromFileMultipleVegetables() throws IOException {
        String filename = "test_load_multiple_vegetables.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("tomato,150.0," + tomato.calculateCalories() + ",Cherry");
            writer.newLine();
            writer.write("cucumber,200.0," + cucumber.calculateCalories() + ",20.0");
            writer.newLine();
            writer.write("carrot,100.0," + carrot.calculateCalories() + ",Сира");
            writer.newLine();
        }

        salad.loadFromFile(filename);
        assertEquals(3, salad.getVegetables().size());
        assertTrue(salad.getVegetables().contains(tomato));
        assertTrue(salad.getVegetables().contains(cucumber));
        assertTrue(salad.getVegetables().contains(carrot));

        new File(filename).delete();
    }

    @Test
    void testToString() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        String expected = "0. " + tomato.toString() + "\n1. " + cucumber.toString() + "\n";
        assertEquals(expected, salad.toString());
    }

    @Test
    void testRemoveVegetableFromEmptySalad() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> salad.removeVegetable(0));
        assertEquals("Овоч з таким індексом не знайдено.", exception.getMessage());
    }

    @Test
    void testLoadFromFilePartiallyInvalid() throws IOException {
        String filename = "test_load_partially_invalid_vegetables.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("tomato,150.0," + tomato.calculateCalories() + ",Cherry");
            writer.newLine();
            writer.write("unknown_vegetable,200.0,20.0");
            writer.newLine();
            writer.write("carrot,100.0," + carrot.calculateCalories() + ",Сира");
            writer.newLine();
        }

        salad.loadFromFile(filename);
        assertEquals(2, salad.getVegetables().size());
        assertTrue(salad.getVegetables().contains(tomato));
        assertTrue(salad.getVegetables().contains(carrot));

        new File(filename).delete();
    }
}
