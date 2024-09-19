package House;
public class House {
    private int id,apartNum,floor,roomAmount;
    private double square;
    private String streetName;
    //Конструктор класу House
    public House(int id, int apartNum, int floor, int roomAmount, double square, String streetName) {
        setId(id);
        setApartNum(apartNum);
        setFloor(floor);
        setRoomAmount(roomAmount);
        setSquare(square);
        setStreetName(streetName);

    }
    //Геттер ід квартири
    public int getId() {
        return id;
    }
    //Сеттер ід квартири
    private void setId(int id) {
        this.id = id;
    }
    //Геттер номеру квартири
    public int getApartNum() {
        return apartNum;
    }
    //Сеттер номеру квартири
    private void setApartNum(int apartNum) {
        this.apartNum = apartNum;
    }
    //Геттер поверху квартири
    public int getFloor() {
        return floor;
    }
    //Сетер поверху квартири
    private void setFloor(int floor) {
        this.floor = floor;
    }
    //Геттер площі квартири
    public double getSquare() {
        return square;
    }
    //Сеттер площі квартири
    private void setSquare(double square) {
        this.square = square;
    }
    //Геттер назви вулиці
    public String getStreetName() {
        return streetName;
    }
    //Сеттер назви вулиці
    private void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    //Геттер кількості кімнат
    public int getRoomAmount() {
        return roomAmount;
    }
    //Сеттер кількості кімнат
    private void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }
    //Метод для виведення інформації про будинок
    public String toString() {
        return "\nHouse ID: "+id+
                "\nApartment Number: "+apartNum+
                "\nFloor: "+floor+
                "\nRoom amount: "+roomAmount+
                "\nSquare: "+square+
                "\nStreet Name: "+streetName;
    }
}
