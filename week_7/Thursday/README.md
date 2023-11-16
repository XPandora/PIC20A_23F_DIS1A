# Interface

## Motivation

**Multiple Inheritance of Behavior**: Java does not support multiple inheritances of state (i.e., extending multiple classes) due to ambiguity issues (like the Diamond Problem). However, interfaces allow multiple inheritances of behavior, as a class can implement multiple interfaces.

## Key Features

- Interfaces are abstract.
- All Methods are Public. For now, we can assume all methods are also abstract (though default and static are also allowed).
- All fields must be public, static, and final.
- No instance fields
- No constructors
- In most cases, interfaces only include public abstract methods.

Classes use the '**implements**' keyword to implement interfaces while sub-interfaces still use the '**extends**' keyword to inherit super-interfaces.

```
interface Shape {
    double calculateArea();
}

interface AdvancedShape extends Shape{
    double calculatePerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double calculateArea() {
        return length * width;
    }
}
```

- The `Shape` interface defines a contract (in this case, a method `calculateArea`) that all implementing classes must fulfill.
- `Circle` and `Rectangle` are concrete classes that implement the `Shape` interface. They provide specific implementations for the `calculateArea` method.
- The `AdvancedShape` interface is an further extension of `Shape` with an additional `calculatePerimeter` method that all implementing classes must fulfill.

## Comparison with Abstract Class

1.  **Method Implementation**: Abstract classes can have a mix of fully implemented (concrete) methods and abstract methods. Interfaces, traditionally, could only have abstract methods, but with Java 8, they can also have default and static methods with implementations.
    
2.  **State Holding**: Abstract classes can have instance variables and thus hold a state. Interfaces cannot hold a state (they can only have static final variables).
    
3.  **Multiple Inheritance**: A class can implement multiple interfaces, thereby inheriting multiple behaviors. However, a class can extend only one abstract class due to Java's restriction on single inheritance for classes.
    
4.  **Constructor**: Abstract classes can have constructors. Interfaces cannot have constructors as they cannot be instantiated.
    
5.  **Accessibility Modifiers**: Methods in an interface are implicitly public. Abstract classes can have methods with various access modifiers (public, protected, private).
    
6.  **Usage Scenario**: Use an abstract class when creating a class hierarchy that shares a common state and behavior. Use an interface when different classes from different hierarchies need to share a contract for behaviors.