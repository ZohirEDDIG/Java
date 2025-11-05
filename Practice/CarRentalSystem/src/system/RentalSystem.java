package system;

import java.util.ArrayList;
import java.util.Scanner;

import models.Car;
import models.Customer;

public class RentalSystem {
    final private ArrayList<Car> cars = new ArrayList<Car>();
    private static int totalRentals = 0;

    public void addCar(Car car) {
        cars.add(car);
    }

    public void  showAvailableCars() {
        System.out.println("Available Cars: ");
        int index = 1;
        for (Car car: cars) {
            if (car.getAvailable()) {
                System.out.print(index + " - ");
                car.displayInfo();
            }
            index++;
        }
    }

    public void rentCar(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        showAvailableCars();

        System.out.print("Choose a car number to rent: ");
        int choice = scanner.nextInt() - 1;

        if (choice >= 0 && choice < this.cars.size() && cars.get(choice).getAvailable()) {
            Car selectedCar = this.cars.get(choice);

            System.out.print("Enter number of rental days: ");
            int days = scanner.nextInt();

            double totalCost = days * selectedCar.getPricePerDay();
            selectedCar.setAvailable(false);
            totalRentals++;

            System.out.println(customer.getName() + " rented " + selectedCar.getBrand() + " " +
            selectedCar.getModel() + " for " + days + " days.");

            System.out.println("Total cost: $" + totalCost);

        } else {
            System.out.println("Invalid choice or car not available!");
        }

        scanner.close();
    }       

    public static void showTotalRentals() {
        System.out.println("Total rentals so far: " + totalRentals);
    }
}