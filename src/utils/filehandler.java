package utils;
import models.car;
import java.io.*;
import java.util.HashMap;

public class filehandler {

    public static void saveData(HashMap<String, car> cars) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("carlist.txt"))) {
            out.writeObject(cars);
            System.out.println(" Data saved successfully!");
        } catch (IOException e) {
            System.out.println(" Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, car> loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cars.txt"))) {
            System.out.println("Data loaded successfully!");
            return (HashMap<String, car>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found.");
            return new HashMap<>();
        }
    }
}
