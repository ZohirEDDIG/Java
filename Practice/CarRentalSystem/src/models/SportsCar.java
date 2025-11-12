package models;

public class SportsCar extends Car {
    final private int horsePower;

    public SportsCar(int id, String brand, String model, int horsePower) {
        super(id, brand, model);
        this.horsePower = horsePower;
    }

    @Override
    public void displayInfo() {
        System.out.println("Id: " + this.id + " - " + this.brand + " " + this.model + " Horse Power " + this.horsePower + " HP" + (this.available ? " Available" : " Not available"));
    }
}
