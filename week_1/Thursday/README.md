# Static Keyword Summary

- Static member variables. Declared and stored in memory even before the main function. They are **shared by all instances**. They won't be destroyed as long as the program is still running.
- Static member functions.
    - They can **only** call other static methods and access static data members. To access non-static member variables/methods, you need to create a class instance first and then access them through that instance.
    - They cannot access '*this'*. '*this'* is a special keyword and refers to some class object instance. It's usually used within class to avoid some aliasing issue. For example, if there is a data member named 'var' in some class, you can also use 'this.var' instead of 'var' to deal with name conflict.
    - Both static data members and static methods can be accessed **without** creating an object. They can be accessed using the class names like `Test.func()`.
- Static Block, which can be used for static initialization of a class. The code inside the static block is executed only once even **before** the main function.

# Class in Java

We know that Java is a purely object oriented language and that means usually we cannot call a method without creating an object. (static method is an exception)

## Writing a new method

You cannot have a method defined like this in Java but it is okay to do so in C++ and Python:

```java
// This is not allowed
void callMe(){
    System.out.println("You just called me!");
}

public class Hello {
    public static void main(String[] args) {
        callMe();
    }
}
```

Java does not allow this and similarly, Java does not also allow this:

```java
// This is not allowed
public static void main(String[] args) {
    callMe();
}
```

Java requires that every variable/field or method/function that you create must be wrapped around in its own class. 
Interesting, this also means that the concept of global variables does not exist in Java like it does in C++ where the following is allowed:

```c++
#include <iostream>
// This is allowed and in fact, this variable is a global variable, meaning, it can be accessed from anywhere within this program(any function/main function)
int gbl = 5;

int main()
{
    std::cout<<gbl<<std::endl;  // Outputs 5
    return 0;
}
```

**Quick question**: If we are writing C++ programs, should we try to use global variable as much as possible or not? Why?

Now then, to solve this problem of the method being outside the class, we wrap it around a class as shown:

```java
// While this is allowed, this still does not solve the problem as the method cannot be called without creating an object
class CallMeClass{
    public void callMe(){
        System.out.println("You just called me!");
    }
}
public class Hello {
    public static void main(String[] args) {
        callMe();
    }
}
```

Note: While we are allowed to define multiple classes within the file, we can define **only 1** public class within the same file. To define the other class as public, we need to create another file for that class. Also note that the **name of the file will also be the same as the public class name**. We will talk more about this in the future

Now, we have successfully wrapped the method around with a class but, remember that, to call member method of a class, you will need to instantiate/create an object of that class to call it. Otherwise it will give you an error.

Therefore, we change the program to as follows:

```java
class CallMeClass{
    public void callMe(){
        System.out.println("You just called me!");
    }
}
public class Hello {
    public static void main(String[] args) {
        CallMeClass c = new CallMeClass();  // c is an object of type CallMeClass
        c.callMe(); // Using c, we can now call the callMe method
    }
}
```

In Java, we can create objects from a class using the `new` method as shown above. Once, we create an object, we use it using the `.`(dot) operator to call its method as shown in the above code.

Alternatively, we could've create the method as part of the same class and created an instance of the same class and call it as shown:

```java
public class Hello {
    public static void main(String[] args) {
        Hello h = new Hello();
        h.callMe();
    }
    public void callMe(){
        System.out.println("You just called me!");
    }
}
```

## Making it static

If all of this seems too much of a hassle to do just to call a method, we can reduce the effort by using the static keyword as shown below:

```java
public class Hello {
    public static void main(String[] args) {
        callMe();
    }
    public static void callMe(){
        System.out.println("You just called me!");
    }
}
```

Notice what the static keyword does... it allows us the call the method without actually creating an object of the class.

Additionally, if we use the static method from the other class, we should add the class's name in the front to call the method as shown:

```java
class CallMeClass{
    public static void callMe(){
        System.out.println("You just called me!");
    }
}
public class Hello {
    public static void main(String[] args) {
        CallMeClass.callMe(); // Notice how I'm still not creating an object but only calling the method albeit using the class name now
    }
}
```

Now, we can finally understand why there is a `static` keyword in the main method as the Java interpreter only calls your method but does not create an object each time it calls it.

## Access Modifiers

In Java there are 4 access modifiers: public, private, protected, and package-private (no explicit modifier). We’ll later talk about protected and package-private later. Generally, they serve the same purpose as they do in C++.

```java
class CallMeClass{
    public int count = 0; // can be accessed from somewhere else besides this class
    public void callMe(){
        System.out.println("You just called me!");
        count++;
    }
}
public class Hello {
    public static void main(String[] args) {
        CallMeClass c = new CallMeClass();
        c.callMe();
        c.callMe();
        c.callMe();
        System.out.println("c is called " + c.count + " times in total.");
    }
}
```

Public variables, are variables that are visible to all classes. Private variables, are variables that are visible only to the class to which they belong.

## Exercise

Implement a Student class with

- public data members: id, name, totalStudentCount
- private data member: GPA, totalGPA
- public member function:
    - a constructor that takes id and name as inputs to initialize data members
    - a function updateGPA() that updates the gpa of a student as well as the totalGPA
    - a function getAverageGPA() that return the average GPA

Below is the initial code framework and please finish it. (**Don't** modify the main function)

```java
public class Student {
    // Declare/define data members here
    // - public data members: id, name, totalStudentCount
    // - private data member: GPA, totalGPA

    public Student(int id, String name) {
        // construtor function
    }

    public void updateGPA(double GPA){
        // update a student's GPA
    }

    public static double getAverageGPA(){
        // return average GPA of all studetns
        double averageGPA = 0.0;
        return averageGPA;
    }
    public static void main(String[] args) {
        // Don't modify the main function
        Student Smith = new Student(1001, "Smith");
        Student Bob = new Student(1050, "Bob");
        
        System.out.println("We have " + Student.totalStudentCount + " now!"); // Expected output: 2

        Smith.updateGPA(3.9);
        Bob.updateGPA(3.5);

        System.out.println("The average GPA is " + Student.getAverageGPA()); // Expected output: 3.7
    }
}
```

# Binary Representation

Due to hardware constraints, data in computers are composed of bits, aka binary representation. Binary representation is a base-2 number system that uses two states 0 and 1 to represent numbers.

## Binary representation to decimal

1.  Identify the binary number, which should consist only of 0s and 1s.
2.  Assign place values to each digit in the binary number, starting from the rightmost digit. The rightmost digit has a place value of 2^0 (which is 1), and each subsequent digit's place value doubles. For example, the second digit from the right has a place value of 2^1 (which is 2), the third digit has a place value of 2^2 (which is 4), and so on.
3.  Multiply and sum:
    Multiply each digit of the binary number by its corresponding place value, and then sum all the results. Start from the rightmost digit and move leftward.

For example, if you have the binary number 1101, you would perform the following calculations:

- 1 * 2^0 = 1
- 0 * 2^1 = 0
- 1 * 2^2 = 4
- 1 * 2^3 = 8

Finally, add the results: 1 + 0 + 4 + 8 = 13.

## Decimal representation to binary

1.  Divide by 2 and keep track of remainder and quotient
2.  Repeat Until the Quotient is 0
    - Continue dividing the quotient from the previous step by 2.
    - Record the remainders and the quotients until the quotient becomes 0.
3.  Read the remainders in **reverse** order and it gives you the binary representation of the decimal number.

Let's convert the decimal number 25 to binary:

- Start with 25.
- Divide 25 by 2: Quotient = 12, Remainder = 1.
- Divide 12 by 2: Quotient = 6, Remainder = 0.
- Divide 6 by 2: Quotient = 3, Remainder = 0.
- Divide 3 by 2: Quotient = 1, Remainder = 1.
- Divide 1 by 2: Quotient = 0, Remainder = 1.

Now, read the remainders in reverse order: 11001, which is the corresponding binary representation.

## Exercise

Translation between binary and decimal representation. Finish the following table:

|     |     |
| --- | --- |
| Binary representation | Decimal representation |
| 10101 |     |
| 10001101 |     |
|     | 35  |
|     | 47  |

Further question: how do we represent fractional and negative number in binary representation?