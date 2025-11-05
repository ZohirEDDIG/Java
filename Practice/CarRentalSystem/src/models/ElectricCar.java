package models;

public class ElectricCar extends Car {
    final private int batteryCapacity;

    public ElectricCar(String brand, String model, int year, double pricePerDay, int batteryCapacity) {
        super(brand, model, year, pricePerDay);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getBrand() + " " + this.getModel() + " (" + this.getYear() + ") - Electric - " +
                this.batteryCapacity + " kWh - $" + this.getPricePerDay() + "/day");
    }
}