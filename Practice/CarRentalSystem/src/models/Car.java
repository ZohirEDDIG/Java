package models;

public class Car {
    final protected int id;
    final protected String brand;
    final protected String model;
    protected boolean available;

    public Car(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.available = true;
    }

    public int getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayInfo() {
        System.out.println("Id: " + this.id + " - " + this.brand + " " + this.model + (this.available ? " Available" : " Not available"));
    }
}