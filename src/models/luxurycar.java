package  models;

public class luxurycar  extends car{
    public luxurycar(String id, String brand, String model, double pricePerDay) {
        super(id, brand, model, pricePerDay);  // call parent constructor
    }

    public double calculaterent(int days) {
        double baseRent = super.calculaterent(days); // call Car's method
        double luxuryFee = baseRent * 0.2;           // add 20% extra
        return baseRent + luxuryFee;
    }
}