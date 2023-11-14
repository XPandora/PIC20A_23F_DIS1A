# Abstract Keyword

## Abstract Class

An abstract class in Java is a class that cannot be instantiated, meaning you cannot create objects of an abstract class. It is used as a base for other classes. It can include abstract methods (methods without a body) as well as concrete methods (methods with a body).

- **Purpose**: Used when you want to share code among several closely related classes.
- **Usage**: Classes extend an abstract class and implement the abstract methods.

```Java
abstract class Animal {
    abstract void makeSound();

    public void eat() {
        System.out.println("I can eat.");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark bark");
    }
}
```

## Abstract Methods

Abstract methods are methods declared in an abstract class without an implementation. They must be implemented by the first concrete subclass that extends the abstract class.

- **Purpose**: To force subclasses to implement a specific behavior.
- **Usage**: Define method signatures without a body.

```Java
abstract class Animal {
    abstract void makeSound();
    // No method body, just the declaration.
}
```

# Final Keyword

## Final Class

A final class in Java is a class that cannot be extended. No other class can inherit from a final class.

- **Purpose**: Used when you want to prevent the alteration of a class.
    
- **Usage**: To provide immutable classes.
    

```Java
final class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
// class AdvancedCalculator extends Calculator {} // This would result in a compilation error
```

## Final Methods

Final methods in Java are methods that cannot be overridden by subclasses. Once a method is declared final in a superclass, it remains the same in all subclasses.

- **Purpose**: To prevent altering the implementation of a method in any subclass.
- **Usage**: Useful when defining an algorithm that should remain consistent across subclasses.

```Java
class Vehicle {
    final void startEngine() {
        System.out.println("Starting engine");
    }
}

class Car extends Vehicle {
    // void startEngine() {} // This would result in a compilation error
}
```

# Override Keyword

The `@Override` annotation in Java is a powerful tool used to indicate that a method is intended to override a method declared in a superclass. Some key points:

- **Compile-Time Check**: When you annotate a method with `@Override`, the compiler checks to ensure that the method is actually overriding a method from a superclass or implementing an abstract method from an interface. If it isn't, the compiler throws an error.
- **Readability and Clarity**: It makes your code more readable and understandable. It clearly communicates to anyone reading the code that the method is meant to override a method from a superclass or implement an interface method.

Note a private method **cannot be** overridden in a subclass. This is because private methods are not visible to subclasses.

# Exercise

**Ex.1** Create an abstract class `Shape` with an abstract method `calculateArea()`. Then, create two subclasses, `Circle` and `Rectangle`, that implement `calculateArea()` method.

```Java
abstract class Shape {
    // an abstract method `calculateArea()
}

class Circle extends Shape {
    public double radius;

    // constructor with a parameter to initialize radius


    // override the abstract method calculateArea() in Shape class
}

class Rectangle extends Shape {
    public double height;
    public double width;

    // constructor with two parameters to initialize height and width

    
    // override the abstract method calculateArea() in Shape class
}

public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(5, 10);

        // print the area of circle and rectangle
        System.out.println("Area of circle: " + circle.calculateArea()); // 78.53981633974483
        System.out.println("Area of rectangle: " + rectangle.calculateArea()); // 50.0
    }
}
```

**Ex.2 **Preliminary knowledge: When the program call a static method, the compiler will look for the corresponding method based in reference class type instead of object class type

```Java
class Parent{
    public static void print(){
        System.out.println("Parent");
    }
}

class Child extends Parent{
    public static void print(){
        System.out.println("Child");
    }
}
public class temp {
    public static void  main(String[] strings)
    {
        Parent p1 = new Parent();
        Parent p2 = new Child();

        // both of them will print Parent
        p1.print();
        p2.print();
    }
}
```

What is the output of the following program:

```Java
class A {
    int x = 10;
    static int y = 20;

    void print() {
        System.out.println("A: x = " + x + ", y = " + y);
    }

    static void staticPrint() {
        System.out.println("A: y = " + y);
    }
}

class B extends A {
    int x = 30;
    static int y = 40;

    void print() {
        System.out.println("B: x = " + x + ", y = " + y);
    }

    static void staticPrint() {
        System.out.println("B: y = " + y);
    }
}

public class Main {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new B();
        B obj3 = new B();

        obj1.print();
        obj2.print();
        obj3.print();

        obj1.staticPrint();
        obj2.staticPrint();
        obj3.staticPrint();

        B downcastObj1 = (B) obj2;
        A castObj2 = obj3;
        B castObj3 = (B) castObj2;

        downcastObj1.print();
        castObj2.print();
        castObj3.print();

        downcastObj1.staticPrint();
        castObj2.staticPrint();
        castObj3.staticPrint();
    }
}
```