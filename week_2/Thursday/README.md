# Overloading

Method overloading is a feature of Java in which a class has more than one method of the **same name** and their **parameters are different**. In other words, we can say that Method overloading is a concept of Java in which we can create multiple methods of the same name in the same class, and all methods work in different ways. When more than one method of the same name is created in a Class, this type of method is called the Overloaded Method. **But method overloading has nothing to do with return-type**.

In java, we do method overloading in two ways:

1.  By changing the number of parameters.
2.  By changing data types.

Here's an example of method overloading in Java:

```Java
public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

In this example, we have three overloaded `add` methods in the `Calculator` class. They have the same name but different parameter lists (number and type of parameters). You can use these methods to perform addition with integers or double values, and the appropriate method will be called based on the arguments you provide.

However, overloading can lead to **ambiguity** when the compiler cannot determine which overloaded method to call based on the provided arguments. This happens when the overloaded methods have parameter lists that are too similar, making it impossible for the compiler to distinguish between them. Here's an example of overloading leading to ambiguity:

```
public class AmbiguousOverloading {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Attempted overloaded method with the same parameter types (ambiguity)
    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        AmbiguousOverloading calculator = new AmbiguousOverloading();
        
        // The following line will lead to a compilation error due to ambiguity.
        int result = calculator.add(5, 7);
        System.out.println(result);
    }
}
```

This results in ambiguity because when you call `calculator.add(5, 7)`, the compiler cannot determine whether you intend to call `add(int a, int b)` or the ambiguous `add(int x, int y)` method

**Open question:** What is the benefit of overloading?

### Exercise:

What is the output of the following code? What if we remove the last two print functions (`print(double x, int y, char z)` and `print(double x, double y, char z)`? (Hint: implicit conversion)

```Java
import java.util.*;

public class App {
    public void print(double x, double y, double z) {
        System.out.println("double: " + x + ", double: " + y + ", double: " + z);
    }

    public void print(double x, int y, int z) {
        System.out.println("double: " + x + ", int: " + y + ", int: " + z);
    }
    
    // what if we remove the last two print functions?
    public void print(double x, int y, char z) {
        System.out.println("double: " + x + ", int: " + y + ", char: " + z);
    }

    public void print(double x, double y, char z) {
        System.out.println("double: " + x + ", double: " + y + ", char: " + z);
    }

    public static void main(String[] args) {
        App puzzle = new App();
    
    	puzzle.print(10.0, 1.5, 'c');
        puzzle.print(10.0, 1, 'c');
    }
}
```

# Control Flow & Loops

## Control Flow Structures

**1\. Conditional Statements (if, else if, else):** conditional statements allow you to execute code based on certain conditions.

```Java
int num = 10;
if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

**2\. Switch Statement:** the switch statement is used to select one of many code blocks to be executed.

```Java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    // ...
    default:
        System.out.println("Invalid day");
}
```

## Loop Structures:

**1.while Loop:** the while loop executes a block of code as long as a condition is true.

```Java
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;
}
```

**2\. do-while Loop:** the do-while loop is similar to the while loop, but it guarantees that the block of code is executed at least once.

```Java
int count = 1;
do {
    System.out.println("Count: " + count);
    count++;
} while (count <= 5);
```

**3\. for Loop:** the for loop provides a concise way to iterate over a range of values.

```Java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

**4\. Enhanced for (for-each) Loop:** the enhanced for loop is used to iterate through arrays or collections.

```Java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

One of the advantages of the enhanced for-loop is that it is simpler and more concise than the basic for-loop, especially when you are iterating over all the elements of an array. However, it has some limitations. For example, you cannot use the enhanced for-loop to modify the elements of an array, as it only provides read-only access to the elements. You also cannot use the enhanced for-loop to iterate over a range of indexes in an array, as it does not provide access to the index of the current element.

### Exercise:

Write a Java program to find the sum of all even numbers from 1 to 50 using a for/while loop.