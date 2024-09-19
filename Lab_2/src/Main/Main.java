package Main;
import House.House;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Список об'єктів класу
        List<House> houses = new ArrayList<>();
        houses.add(new House(1, 101, 3, 2, 35.6, "Main Street"));
        houses.add(new House(2, 102, 4, 3, 40.0, "Park Avenue"));
        houses.add(new House(3, 103, 2, 1, 23.7, "High Street"));
        houses.add(new House(4, 104, 1, 3, 54.7, "Oak Street"));
        houses.add(new House(5, 105, 8, 2, 30.2, "Pine Street"));

        int amountRooms,minFloor,maxFloor;
        double square;
        // Перевірка введення кількості кімнат
        while (true) {
            try {
                System.out.println("Введіть кількість кімнат для пошуку квартир:");
                amountRooms = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат введення! Будь ласка, введіть ціле число.");
                scan.next();  // очищаємо буфер
            }
        }
        System.out.println("a) Список квартир з " + amountRooms + " кімнатами:");
        HousesWithRooms(houses, amountRooms);
        //HousesWithRooms(houses, 3);


// Перевірка введення мінімального та максимального поверхів
        while (true) {
            try {
                System.out.println("Введіть кількість кімнат для пошуку квартир:");
                amountRooms = scan.nextInt();
                System.out.println("Введіть мінімальний поверх для пошуку квартир:");
                minFloor = scan.nextInt();
                System.out.println("Введіть максимальний поверх для пошуку квартир:");
                maxFloor = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат введення! Будь ласка, введіть ціле число.");
                scan.next();  // очищаємо буфер
            }
        }

        System.out.println("\nb) Список квартир з " + amountRooms + " кімнатами на поверхах між " + minFloor + " і " + maxFloor + ":");
        HousesWithFloorAndRooms(houses, amountRooms, minFloor, maxFloor);
        //HousesWithFloorAndRooms(houses, 3, 2, 5);

        // Перевірка введення площі
        while (true) {
            try {
                System.out.println("Введіть площу для пошуку квартир:");
                square = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат введення! Будь ласка, введіть число.");
                scan.next();  // очищаємо буфер
            }
        }

        System.out.println("\nc) Список квартир з площею більше " + square + " кв.м:");
        HousesWithSquare(houses, square);
        //HousesWithSquare(houses, 60.0);
    }
    //Функція для виводу будинків з певною кількістю кімнат
    public static void HousesWithRooms(List<House> houses,int rooms) {
        int amount=0;
        for(House house: houses) {
            if(house.getRoomAmount()==rooms) {
                System.out.println(house);
                amount++;
            }

        }
        if (amount==0){
            System.out.println("Таких квартир немає");
        }
    }
    //Функція для виводу будинків з певною кількістю кімнат і на поверхах
    public static void HousesWithFloorAndRooms(List<House> houses,int rooms,int MinFloor,int MaxFloor) {
        int amount=0;
        for(House house: houses) {

            if(house.getRoomAmount()==rooms&&house.getFloor()>=MinFloor&&house.getFloor()<=MaxFloor) {
                System.out.println(house);
                amount++;
            }

        }
        if (amount==0){
            System.out.println("Таких квартир немає");
        }
    }
    //Виводить список будинків де площа більща ніж задана
    public static void HousesWithSquare(List<House> houses,double square) {
        int amount=0;

        for(House house: houses) {
            if(house.getSquare()>=square) {
                System.out.println(house);
                amount++;
            }

        }
        if (amount==0){
            System.out.println("Таких квартир немає");
        }
    }

}