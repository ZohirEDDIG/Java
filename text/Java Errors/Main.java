import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int doubleX(int x) {
        return x * 2;
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are older enough!");
        }
    }

    public static void main(String[] args) {
        // int x = 5
        // System.out.println(x);

        // System.out.println(myVar);

        // int x = "Hello";
        // System.out.println(x);

        // int x = 10;
        // int y = 0;
        // int result = x / y;
        // System.out.println(result);

        // int[] numbers = {1, 2, 3};
        // System.out.println(numbers[8]);

        // int x = 10;
        // int y = 2;
        // int sum = x - y;
        // System.out.println("x + y = " + sum);


        // int x = 10;
        // int y = 0;

        // System.out.println("Before division");

        // int result = x / y;

        // System.out.println("Result: " + result);

        // int age = 17;
        // System.out.println("Age: " + age);

        // if (age >= 18) {
        //     System.out.println("Access granted");
        // } else {
        //     System.out.println("Access denied");
        // }

        // For Debugging
        // int x = 5;
        // int xDoubled = doubleX(x);
        // System.out.println(x + " doubled is " + xDoubled); 

        // int[] myNumbers = {1, 2, 3};
        // System.out.println(myNumbers[10]);

        // try {
        //     int[] myNumbers = {1, 2, 3};
        //     System.out.println(myNumbers[10]);
        // } catch (Exception e) {
        //     System.out.println("Something went wrong.");
        // } finally {
        //     System.out.println("The 'try catch' if finished.");
        // }

        // checkAge(15);
        // checkAge(20);

        // try {
        //     int[] numbers = {1, 2, 3};
        //     System.out.println(numbers[10]);  // ArrayIndexOutOfBoundsException
        //     int result = 10 / 0;              // ArithmeticException
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Array index does not exist.");
        // } catch (ArithmeticException e) {
        //     System.out.println("Cannot divide by zero.");
        // } catch (Exception e) {
        //     System.out.println("Something else went wrong.");
        // }

        // try {
        //     int result = 10 / 0;
        // } catch (Exception e) {
        //     System.out.println("General error.");
        // } catch (ArithmeticException e) {
        //     // This will never be reached
        //     System.out.println("Divide by zero.");
        // }

        // try {
        //     int result = 10 / 0;
        //     int[] numbers = {1, 2, 3};
        //     System.out.println(numbers[10]);
        // }  catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Math error or array error occurred.");
        // }

        // try (FileOutputStream output = new FileOutputStream("filename.txt");) {
        //     // FileOutputStream output = new FileOutputStream("filename.txt");
        //     output.write("Hello".getBytes());
        //     // no need to call close() here 
        //     // output.close();  // must close manually
        //     System.out.println("Successfully wrote to the file.");
        // } catch (IOException e) {
        //     System.out.println("Error writing file.");
        // }

        boolean isError;
        Scanner scanner = new Scanner(System.in);

        do {
            isError = false;
            try {
                System.out.print("Enter a number: ");
                int x = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                System.out.print("Enter another number: ");
                int y = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                System.out.println(x + " + " + y + " = " + (x + y));

            } catch (Exception e) {
                isError = true;
                System.out.println("Please check your input. You must enter a number.");
                scanner.nextLine(); // clear the invalid input
            }
        } while (isError);

        scanner.close();
    }
}