import models.*;
import system.RentalSystem;

public class Main {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Car ford = new Car("Ford", "Focus", 2018, 70);

        SportsCar bmw = new SportsCar("BMW", "M3", 2021, 120, 420);

        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2023, 150, 300);

        system.addCar(ford);
        system.addCar(bmw);
        system.addCar(tesla);

        Customer zohir = new Customer("Zohir");

        system.rentCar(zohir);

        RentalSystem.showTotalRentals();
    }
}