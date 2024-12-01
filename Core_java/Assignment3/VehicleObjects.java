package Assignment3;

class Vehicle {
    // Common attributes and methods for all vehicles can be defined here
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String brand, String model, int year, int numDoors) {
        super(brand, model, year);
        this.numDoors = numDoors;
    }

    public void displayCarInfo() {
        displayInfo();
        System.out.println("Number of doors: " + numDoors);
    }
}

class Rickshaw extends Vehicle {
    private boolean hasCanopy;

    public Rickshaw(String brand, String model, int year, boolean hasCanopy) {
        super(brand, model, year);
        this.hasCanopy = hasCanopy;
    }

    public void displayRickshawInfo() {
        displayInfo();
        System.out.println("Has canopy: " + (hasCanopy ? "Yes" : "No"));
    }
}

class Bike extends Vehicle {
    private String bikeType;

    public Bike(String brand, String model, int year, String bikeType) {
        super(brand, model, year);
        this.bikeType = bikeType;
    }

    public void displayBikeInfo() {
        displayInfo();
        System.out.println("Bike type: " + bikeType);
    }
}

public class VehicleObjects {
    public static void main(String[] args) {
        Car car1 = new Car("Tata", "Harrier", 2023, 4);
        car1.displayCarInfo();

        Rickshaw auto1 = new Rickshaw("Bajaj", "RE", 2022, true);
        auto1.displayRickshawInfo();

        Bike bike1 = new Bike("Bajaj", "Freedom 251", 2024, "CNG");
        bike1.displayBikeInfo();

        car1.displayInfo();
    }
}