package models;

import java.util.ArrayList;

public class Customer {
    private String username;
    private String password;
    private ArrayList<Car> rentedCars = new ArrayList<Car>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<Car> getRentedCars() {
        return rentedCars;
    }

    public void addRentedCar(Car car) {
        rentedCars.add(car);
    }
}