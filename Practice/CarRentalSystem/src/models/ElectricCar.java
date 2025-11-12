package models;

public class ElectricCar extends Car {
    final private int batteryCapacity;

    public ElectricCar(int id, String brand, String model, int batteryCapacity) {
        super(id, brand, model);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Id: " + this.id + " - " + this.brand + " " + this.model + " Electric " + this.batteryCapacity + " kWh" +  (this.available ? " Available" : " Not available"));
    }
}