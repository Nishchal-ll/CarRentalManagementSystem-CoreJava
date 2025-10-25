import models.*;
import services.rentalservice;
import utils.filehandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        rentalservice service = rentalservice.getInstance();
        service.getCars().putAll(filehandler.loadData());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Car Rental System ====");
            System.out.println("1. Add Car");
            System.out.println("2. Show Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Save & Exit");
            System.out.print("Choose option: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter Price/Day: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Type (1=Economy, 2=Luxury): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    car car = (type == 2)
                            ? new luxurycar(id, brand, model, price)
                            : new economycar(id, brand, model, price);
                    service.addCar(car);
                    break;

                case 2:
                    service.showCars();
                    break;

                case 3:
                    System.out.print("Enter Car ID: ");
                    String rid = sc.nextLine();
                    System.out.print("Enter Days: ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    service.rentCar(rid, days);
                    break;

                case 4:
                    System.out.print("Enter Car ID: ");
                    String rid2 = sc.nextLine();
                    service.returnCar(rid2);
                    break;

                case 5:
                    filehandler.saveData(service.getCars());
                    System.out.println(" Goodbye!");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}
