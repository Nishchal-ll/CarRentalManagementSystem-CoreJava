package models;
import interfaces.rentable;

public class car implements rentable {
    private String id;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available = true;

    public car(String id, String brand, String model, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }

    @Override
    public void rentcar(int days) {
        if (available) {
            double total = calculaterent(days);
            System.out.println( model + " rented for " + days + " days. Total: $" + total);
            available = false; // mark as rented
        } else {
            System.out.println(" Car already rented.");
        }
    }

    @Override
    public void returncar() {
        if (!available) {
            available = true;
            System.out.println( model + " returned successfully.");
        } else {
            System.out.println(" Car was not rented.");
        }
    }

    @Override
    public double calculaterent(int days) {
        return pricePerDay * days;
    }

    public String toString() {
        return "[" + id + "] " + brand + " " + model +
                " | $" + pricePerDay + "/day | " +
                (available ? "Available" : "Rented");
    }
}