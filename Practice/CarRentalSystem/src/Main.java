import models.Car;
import models.SportsCar;
import models.ElectricCar;

import system.RentalSystem;

public class Main {
    public static void main(String[] args) {
        Car ford = new Car(1, "Ford", "Focus");
        Car dacia = new Car(2, "Dacia", "Duster");
        Car renault = new Car(3, "Renault", "Megan IV");
        SportsCar bmw = new SportsCar(4, "BMW", "M3", 420);
        ElectricCar tesla = new ElectricCar(5, "Tesla", "Model 3", 300);

        RentalSystem.addCar(ford);
        RentalSystem.addCar(dacia);
        RentalSystem.addCar(renault);

        RentalSystem.addCar(bmw);
        RentalSystem.addCar(tesla);

        RentalSystem.welcome();
    }
}