package models;

public class Car {
    final private String brand;
    final private String model;
    final private int year;
    final private double pricePerDay;
    private boolean available;

    public Car(String brand, String model, int year, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayInfo() {
        System.out.println(this.brand + " " + this.model + " (" + this.year + ") - $" + this.pricePerDay + "/day");
    }
}