# Summary of Inheritance and Polymorphism

## Inheritance

1.  Inheritance allows classes to inherit properties(fields) and behaviors(methods) from other classes, creating a hierarchy of classes. This allows different classes share the same method implementation and data member names, which **avoids the code duplication.**
2.  All the public, private and default methods/fields will be inherited by the child class. However, within the child class, you cannot access the private methods/fields defined in the parent class.
3.  Within the child class, you can not only define additional methods/fields, but also **override** the methods that are originally defined in the parent class.

## Polymorphism

1.  **Upcasting**: a subclass/child class object is assigned to a superclass/parent class reference variable. Upcasting is always valid.
2.  **Downcasting:** a superclass/parent class object/reference variable is assigned to a subclass/ child class reference variable. Downcasting is not always allowed.
3.  Whether you can do upcasting or downcasting depends on the class type (class 1)of the assigned **object** (**not reference!**) and the class type (class 2) of the target **reference variable**. If class1 is exactly class2 or class1 is a child class of class2, then the casting is valid.
4.  Whether you can access some field/method of a reference variable depends on if this field/method is defined in the **class of reference variable**. However, the specific implementation of a method is determined by **the class of object it refers to**! This is the root of polymorphism.

```Java
Parent p = new Child();
// function someMethod() is defined in class Parent
// the specific behaviors of someMethod() depends on its implementation in the child class 
p.someMethod();
```

# Method Overloading and Vararg Ambiguity

Overloading allows different methods to have same name, but different signatures where signature can differ by number of input parameters or type of input parameters or both. Here is an example of the ambiguity caused by method overloading and vararg:

```Java
public class varargsDemo
{
    public static void main(String[] args)
    {
        func(1,2);
        func();
        func(1);
    }
    //varargs method with int datatype
    static void func(int... x)
    {
        System.out.println("int varargs");
    }
    // method with two int parameters
    static void func(int x1, int x2)
    {
        System.out.println("int, int");
    }
    // method with one double datatype
    static void func(double x)
    {
        System.out.println("double");
    }
}
```

When there are multiple function candidates, compiler will choose the one that is more specific to the input variables. Besides, it turns out the priority of the method with variable arguments is very low. Below is the output of the above code:

```Java
int, int // func(1,2), func(int, int) is more specific to the input variable
int varargs // func(), only func(int...) is a valid candidate
double // func(1), this one is a bit weird, compiler thinks func(double) is more specific compared to func(int...)
```