package system;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.Car;
import models.Customer;

public class RentalSystem {
    private static final ArrayList<Customer> customers = new ArrayList<Customer>();
    private static Customer currentCustomer;

    private static final ArrayList<Car> cars = new ArrayList<Car>();

    private static final Scanner scanner = new Scanner(System.in);

    private static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    private static void register() {
        System.out.println("Please enter your information to register.");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]{5,8}$");

        while (!usernamePattern.matcher(username).matches()) {
            System.out.print("Invalid username format. Please try again(3-8 characters, only letters, numbers, hyphens, and underscores): ");
            username = scanner.nextLine();
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$");

        while (!passwordPattern.matcher(password).matches()) {
            System.out.print("Invalid password format. Please try again(8 characters, at least 1 lowercase letter, 1 uppercase letter, and 1 number): ");
            password = scanner.nextLine();
        }

        Customer customer = new Customer(username, password);

        addCustomer(customer);

        System.out.println("User registred successfully.");
        login();    
    }

    private static void login() {
        System.out.println("Please enter your information to login.");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        while (username.trim().equals("")) {
            System.out.print("Please enter your username: ");
            username = scanner.nextLine();
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        while (password.trim().equals("")) {
            System.out.print("Please enter your password: ");
            password = scanner.nextLine();
        }

        for (Customer customer: customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                System.out.println("Login successful.");
                currentCustomer = customer;
                System.out.println("Welcome " + currentCustomer.getUsername() + "!");
                showSystemMenu();
                return;
            }
        }

        System.out.print("Invalid username or password. Enter 1 to try again, 2 to register or press enter to exit: ");

        boolean isError;
        do {
            isError = false;
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    login();
                } else if (choice == 2) {
                    register();
                } else if (choice == 3) {
                    return;
                } else {
                    System.out.println("Invalid input.");
                    isError = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                isError = true;
                scanner.nextLine();
            }
        } while (isError);
    }

    private static void showAllCars() {
        System.out.println("All cars:");
        for (Car car: cars) {
            car.displayInfo();
        }
    }

    private static void showAvailableCars() {
        System.out.println("Available cars:");
        for (Car car: cars) {
            if (car.getAvailable()) {
                car.displayInfo();
            }
        }
    }

    private static void rentCar() {
        showAvailableCars();
        System.out.print("Enter the ID of the car you want to rent: ");

        boolean isError;
        do {
            isError = false;
            try {
                int carId = scanner.nextInt();
                scanner.nextLine();

                for (Car car: cars) {
                    if (car.getId() == carId && car.getAvailable()) {
                        currentCustomer.addRentedCar(car);
                        car.setAvailable(false);
                        System.out.println(currentCustomer.getUsername() + " has rented successfully " + car.getBrand() + " " + car.getModel());
                        showSystemMenu();
                        return;
                    }
                }

                System.out.println("Invalid car ID.");
                isError = true;
            } catch (Exception e) {
                System.out.println("Invalid input.");
                isError = true;
                scanner.nextLine();
            }
        } while (isError);
    }

    public static void showYourRentals() {
        System.out.println("Cars rented by you: ");
        for (Car car: currentCustomer.getRentedCars()) {
            car.displayInfo();
        }
    }


    private static void showSystemMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show all cars");
        System.out.println("2. Show available cars");
        System.out.println("3. Rent a car");
        System.out.println("4. Return a car");
        System.out.println("5. Show you rentals");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        boolean isError;
        do {
            isError = false;
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        showAllCars();
                        break;
                    case 2:
                        showAvailableCars();
                        break;
                    case 3:
                        rentCar();
                        break;
                    case 4:
                        break;
                    case 5:
                        showYourRentals();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input.");
                        System.out.println("Please enter a valid choice: ");
                        isError = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                System.out.print("Please enter a valid choice: ");
                scanner.nextLine();
                isError = true;
            }
        } while (isError);

        showSystemMenu();
    }

    public static void welcome() {
        System.out.println("Welcome to the Car Rental System!");
        
        boolean isError;
        do {
            isError = false;
            try {
                System.out.print("Enter 1 to login or 2 to register: "); 

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    login();
                } else if (choice == 2) {
                    register();
                } else {
                    System.out.println("Invalid input.");
                    isError = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                isError = true;
                scanner.nextLine();
            }
        } while (isError);
    }
}