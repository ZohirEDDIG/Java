# Java Generics

## Java Generics
- Generic allow you to write classes, interfaces, and methods that with different data types, without having to specify the exact  type in advance.
- This makes your code more flexible, reusable, and type-safe.

## Why Use Generics ?
- **Code Reusablity**: Write one class or method that works with different data types.
- **Type Safety**: Catch type errors at compile time instead of runtime.
- **Cleaner Code**: No need for casting when retrieving objects.

## Generic Class Example 
- You can create a class that works with different data types using generics:

```
class Box<T> {
    T value; // T is a placeholder for any data type

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Box to hold a String 
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("Value: " + stringBox.get());

        // Create a Box to hold a Integer 
        Box<Integer> intBox = new Box<>();
        intBox.set(50);
        System.out.println("Value: " + intBox.get());
    }
}
```

- `T` is a generic type parameter. It's like a placeholder for a data type.
    - When you create a `Box<String>`,`t` becomes `String`.
    - When you create a `Box<Integer>`,`t` becomes `Integer`.
- This way, the same class can be reused with different data types without rewriting the code.

## Generic Method Example
- You can also create methods that work with any data type using generics:

```
public class Main {
    // Generic method: works with any type T
    public static <T> void printArray(T[] array) {
        for (T item : array) {
        System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Array of Strings
        String[] names = {"Jenny", "Liam"};

        // Array of Integers
        Integer[] numbers = {1, 2, 3};

        // Call the generic method with both arrays
        printArray(names);
        printArray(numbers);
    }
}
```

### Example Explained
- `<T>` is a generic type parameter - it means the method can work with any type: `String`, `Integer`, `Double`, etc.
- The method `printArray()` takes an array of type `T` and prints every element.
- When you call the method, Java figures out what `T` should be based on the argument you pass in.
- This is useful when you want to write one method that works with multiple types, instead of repeating code for each one.

## Bounded Types
- You can use the `extends` keyword to limit the types a generic class or method can accept.
- For example, you can reuire that the type must be a subclass of `Number`:

```
class Stats<T extends Number> {
    T[] nums;

    // Constructor 
    Stats(T[] nums) {
        this.nums = nums;
    }

    // Calculate average
    double average() {
        double sum = 0;
        for (T num: nums) {
            sum += num.doubleValue();
        }

        return sum / nums.length;
    }
}

public class Main {
    public static void main(String[] args) {
        // Use with Integer
        Integer[] intNums = {10, 20, 30, 40};
        Stats<Integer> intStats = new Stats<>(intNums);
        System.out.println("Integer average: " + intStats.average());

        // Use with Double
        Double[] doubleNums = {1.5, 2.5, 3.5};
        Stats<Double> doubleStats = new Stats<>(doubleNums);
        System.out.println("Double average: " + doubleStats.average());
    }
}
```

- Even though int values are used in the first case, the .doubleValue() method converts them to double, so the result is shown with a decimal point.

### Example Explained
- `<T extends Number>`: Restricts `T` to only work with numeric types like `Integer`, `Double`, or `Float`.
- `.doubleValue()`: Converts any number to a double for calculation.
- Works for any array of numbers as long as the elements are subclasses of `Number`.

## Generic Collections
- Java Collections like ArrayList and HashMap use generics internally:

```
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
String fruit = list.get(0); // No need to cast
```

## Summary
- Generics make your code flexible and type-safe.
- Use `T` or another letter to define a type placeholder.
- Generics can be applied to classes, methods, and interfaces.
- Use bounds to limit what types are allowed.