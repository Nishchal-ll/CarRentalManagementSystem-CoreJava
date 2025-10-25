package services;
import models.car;
import java.util.HashMap;

public class rentalservice {
    private static rentalservice instance;        // Singleton instance
    private HashMap<String, car> cars = new HashMap<>();

    // Private constructor (so no one can make new instances)
    private rentalservice() {}

    // Singleton getter method
    public static rentalservice getInstance() {
        if (instance == null)
            instance = new rentalservice();
        return instance;
    }

    // Add new car
    public void addCar(car car) {
        if (cars.containsKey(car.getId())) {
            System.out.println(" This ID already exists. Please enter a new ID.");
        } else {
            cars.put(car.getId(), car);
            System.out.println(" Car added successfully!");
        }
    }

    // Display all cars
    public void showCars() {
        if (cars.isEmpty()) {
            System.out.println(" No cars available.");
            return;
        }
        System.out.println("\n--- Car List ---");
        for (car c : cars.values()) {
            System.out.println(c);
        }
    }

    // Rent car
    public void rentCar(String id, int days) {
        car car = cars.get(id);
        if (car != null) {
            car.rentcar(days);
        } else {
            System.out.println(" Car not found!");
        }
    }

    // Return car
    public void returnCar(String id) {
        car car = cars.get(id);
        if (car != null) {
            car.returncar();
        } else {
            System.out.println(" Car not found!");
        }
    }

    public HashMap<String, car> getCars() {
        return cars;
    }
}