package game;

import droids.Droid;
import droids.Archer;
import droids.Healer;
import droids.Mage;
import droids.Intimidator;
import droids.FireDroid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Droid> droids = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void start() {
        while (true) {
            System.out.println("БИТВА ДРОЇДІВ:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати дроїдів");
            System.out.println("3. Бій 1 vs 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> fight1v1();
                case 4 -> teamFight();
                case 5 -> {
                    System.out.println("Вихід з гри!");
                    return;
                }
                default -> System.out.println("Неправильний вибір.Введіть ще раз!");
            }
        }
    }

    private void createDroid() {
        System.out.println("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();
        System.out.println("Виберіть тип дроїда (1: Archer, 2: Healer, 3: Mage, 4: Intimidator, 5: FireDroid):");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Droid droid = switch (type) {
            case 1 -> new Archer(name);
            case 2 -> new Healer(name);
            case 3 -> new Mage(name);
            case 4 -> new Intimidator(name);
            case 5 -> new FireDroid(name);
            default -> null;
        };

        if (droid != null) {
            droids.add(droid);
            System.out.println("Дроїд створений " + droid);
        } else {
            System.out.println("Неправильний вибір");
        }
    }

    private void showDroids() {
        // Завантажуємо дроїдів з файлу
        loadDroidsFromFile("droids.txt");

        if (droids.isEmpty()) {
            System.out.println("No droids created.");
        } else {
            for (Droid droid : droids) {
                System.out.println(droid);
            }
        }
    }


    private void fight1v1() {
        loadDroidsFromFile("droids.txt");
        if (droids.size() < 2) {
            System.out.println("Потрібно щонайменше 2 дроїда для бою");
            return;
        }

        System.out.println("Виберіть першого дроїда:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i));
        }
        int firstDroidIndex = scanner.nextInt() - 1;

        System.out.println("Виберіть другого дроїда:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i));
        }
        int secondDroidIndex = scanner.nextInt() - 1;

        if (firstDroidIndex < 0 || firstDroidIndex >= droids.size() || secondDroidIndex < 0 || secondDroidIndex >= droids.size()) {
            System.out.println("Неправильний вибір.");
            return;
        }

        Droid droid1 = droids.get(firstDroidIndex);
        Droid droid2 = droids.get(secondDroidIndex);

        StringBuilder battleLog = new StringBuilder(); // Для запису хроніки бою

        battleLog.append("Бій між ").append(droid1.getName()).append(" і ").append(droid2.getName()).append("\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            // Відображення стану дроїдів перед атакою
            String droid1Status = droid1.getName() + " (Здоров'я: " + droid1.getHealth() + ")";
            String droid2Status = droid2.getName() + " (Здоров'я: " + droid2.getHealth() + ")";
            System.out.println(droid1Status);
            System.out.println(droid2Status);

            battleLog.append(droid1Status).append("\n");
            battleLog.append(droid2Status).append("\n");

            // Дії дроїдів
            droid1.specialAbility(droid2);
            battleLog.append(droid1.getName()).append(" атакує!\n");

            if (droid2.isAlive()) {
                droid2.specialAbility(droid1);
                battleLog.append(droid2.getName()).append(" атакує!\n");
            }
        }

        // Виведення результату бою
        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " переміг!");
            battleLog.append(droid1.getName()).append(" переміг!\n");
        } else {
            System.out.println(droid2.getName() + " переміг!");
            battleLog.append(droid2.getName()).append(" переміг!\n");
        }

        // Збереження хроніки бою в файл
        saveBattleLog(battleLog.toString());
    }

    private void saveBattleLog(String battleLog) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("battles.txt", true))) { // true для додавання до файлу
            writer.write(battleLog);
            System.out.println("Бій збережено у файлі battles.txt");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні бою: " + e.getMessage());
        }
    }



    private void loadDroidsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    continue; // Некоректний формат рядка
                }

                String type = parts[0].trim();  // Тип дроїда
                String name = parts[1].trim();  // Ім'я дроїда
                int health = Integer.parseInt(parts[2].trim());  // Здоров'я
                int damage = Integer.parseInt(parts[3].trim());  // Шкода

                // Створюємо дроїда залежно від типу
                Droid droid = null;
                switch (type.toLowerCase()) {
                    case "archer":
                        droid = new Archer(name, health, damage);
                        break;
                    case "healer":
                        droid = new Healer(name, health, damage);
                        break;
                    case "mage":
                        droid = new Mage(name, health, damage);
                        break;
                    case "intimidator":
                        droid = new Intimidator(name, health, damage);
                        break;
                    case "fire":
                        droid = new FireDroid(name, health, damage);
                        break;
                    default:
                        System.out.println("Невідомий тип дроїда: " + type);
                }

                if (droid != null) {
                    droids.add(droid);  // Додаємо дроїда до загального списку
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка читання дроїдів з файлу: " + e.getMessage());
        }
    }


    private void teamFight() {
        if (droids.size() < 4) { // Перевіряємо, чи є достатньо дроїдів
            System.out.println("Для організації командного бою потрібно не менше чотирьох дроїдів.");
            return;
        }

        // Створення команд
        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        // Вибір дроїдів для команд
        System.out.println("Виберіть дроїдів для команди 1:");
        for (int i = 0; i < 2; i++) {
            System.out.println("Виберіть дроїда " + (i + 1) + " для команди 1:");
            for (int j = 0; j < droids.size(); j++) {
                System.out.println((j + 1) + ". " + droids.get(j));
            }
            int droidIndex = scanner.nextInt() - 1;
            if (droidIndex < 0 || droidIndex >= droids.size()) {
                System.out.println("Неправильний вибір");
                return;
            }
            team1.add(droids.get(droidIndex));
            droids.remove(droidIndex); // Видаляємо вибраного дроїда, щоб він не потрапив в іншу команду
        }

        System.out.println("Виберіть дроїдів для команди 2:");
        for (int i = 0; i < 2; i++) {
            System.out.println("Вибери дроїда " + (i + 1) + " для команди 2:");
            for (int j = 0; j < droids.size(); j++) {
                System.out.println((j + 1) + ". " + droids.get(j));
            }
            int droidIndex = scanner.nextInt() - 1;
            if (droidIndex < 0 || droidIndex >= droids.size()) {
                System.out.println("Invalid selection.");
                return;
            }
            team2.add(droids.get(droidIndex));
            droids.remove(droidIndex); // Видаляємо вибраного дроїда з загального списку
        }

        // Початок бою
        System.out.println("Команда 1 проти команди 2! Бій починається!");

        // Бій: дроїди команд атакують один одного
        while (!team1.isEmpty() && !team2.isEmpty()) {
            Droid droid1 = team1.get(0);
            Droid droid2 = team2.get(0);

            System.out.println("Бій між " + droid1.getName() + " і " + droid2.getName());

            // Атакує дроїд з першої команди
            droid1.specialAbility(droid2);
            if (!droid2.isAlive()) {
                System.out.println(droid2.getName() + "з команди 2 зазнав поразки!");
                team2.remove(droid2); // Видаляємо дроїда з команди 2
            }

            // Якщо дроїд з другої команди ще живий, він атакує
            if (droid2.isAlive()) {
                droid2.specialAbility(droid1);
                if (!droid1.isAlive()) {
                    System.out.println(droid1.getName() + " з команди 1 зазнав поразки!»");
                    team1.remove(droid1); // Видаляємо дроїда з команди 1
                }
            }

            System.out.println(); // Додаємо порожній рядок для зручності виводу
        }

        // Визначення переможця
        if (team1.isEmpty()) {
            System.out.println("Команда 2 виграє битву!");
        } else {
            System.out.println("Команда 1 виграє битву!");
        }
    }
}


