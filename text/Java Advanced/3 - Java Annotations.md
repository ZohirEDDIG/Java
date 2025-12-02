# Java Annotations

## Java Annotations
- Annotations are **special notes** you add to your Java code. They start with the `@` symbol.
- They **don't change how your program runs**, but they give **extra information** to the compiler ot tools.

## Built-in Annotations
- Java includes several built-in annotations. Here are some of the most commonly used:

| Annotation           | Description                                                 |
| :------------------- | :---------------------------------------------------------- |
| @Override            | Indicates that a method overrides a method in a superclass  |
| @Deprecated          | Marks a method or class as outdated or discouraged from use |
| @SuppressWarnings    | Tells the compiler to ignore certain warnings               |

## Override Annotation 
- The `@Override` annotation helps the compiler check that a method really overrides a methode from a superclass.
- It's not required, but it's highly recommended because it helps catch errors.
- In this example, we clearly indicate that we are overriding a method:

### Example

```
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override 
    void makeSound() {
        System.out.println("Woof!");  
    }
}
```

- If you accidentally write the wrong method name (e.g. `makesound()`), the compiler will show an error like:

### Example

```
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override 
    void makesound() { // Typo here!
        System.out.println("Woof!");  
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}
```

- Result:

Main.java:8: error: method does not override or implement a method from a supertype
  @Override
  ^
1 error

- That's the power of `@Override` - it prevents silent mistakes.
- If you try to remove the `@Override` line in the example above, the compiler won't warn you, and the method won't override anything. Your program may still run, but it could behave unexpectedly because the intended method was never actually overridden.

## @Deprecated Annotation
- The `@Deprecated` annotation warns developers not to use a method because it may be removed or replaced in the future:

### Example

```
public class Main {
    @Deprecated
    static void oldMethod() {
        System.out.println("This method is outdated.");
    }

    public static void main(String[] args) {
        oldMethod(); // This will show a warning in most IDEs
    }
}
```

- Even though the method runs and prints the message, most IDEs or compilers will show a warning like this:

warning: [deprecation] oldMethod() in Main has been deprecated

## @SuppressWarnings Annotation
- The @SuppressWarnings annotation tells the compiler to ignore specific warnings, like "unchecked" or "deprecation":

### Example 

```
import java.util.ArrayList;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList cars = new ArrayList();
        cars.add("Volvo");
        System.out.println(cars);
    }
}
```

- Result 

[Volvo]

- Using raw types like `ArrayList` without specifying a type (e.g. `ArrayList<String>`) usually causes an "unchecked" warning.
- The annotation `@SuppressWarnings("unchecked")` tells the compiler to ignore that warning. This is useful when working with old code or when you're sure the operation is safe.
- However, instead of hiding the warning, you can fix it like this:

`ArrayList<String> cars = new ArrayList<>();`

This approach is type-safe and avoids the need for suppression.