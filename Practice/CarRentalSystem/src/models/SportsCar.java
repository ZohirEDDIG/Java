package models;

public class SportsCar extends Car {
    final private int horsePower;

    public SportsCar(String brand, String model, int year, double pricePerDay, int horsePower) {
        super(brand, model, year, pricePerDay);
        this.horsePower = horsePower;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getBrand() + " " + this.getModel() + " (" + this.getYear() + ") - " +
        this.horsePower + " HP - $" + this.getPricePerDay() + "/day");
    }
}
