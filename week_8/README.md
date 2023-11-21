# Four Access Modifiers

- **public:** Elements with this modifier are accessible from anywhere, both within and outside the package. For example, a public method can be called from any other class.
    
- **private:** Elements with this modifier are accessible only within the same class. They are not visible to other classes, even within the same package.
    
- **default (no modifier):** Elements with no access modifier are accessible within the same package only. If no access modifier is specified, the default access is applied.
    
- **protected:** Elements with this modifier are accessible within the same class, within the same package, and by subclasses, even if they are in a different package.
    

Within a package, 'public', 'default' and 'protected' are almost the same. Other classes within the same package can access these fields/methods without any problems.

However, the thing gets more complicated when multiple packages are involved. Let's assume we have a superclass **A** and a subclass **B**, and they are in different packages. Then, for protected members in **A**:

- **A**'s protected members are accessible in class **B**
    
- **A**'s protected constructor is accessible by **B**'s constructors by using the super keyword but is not accessible for direct use.
    
- **A**'s protected members are not accessible by instances of **A**, but are accessible by instances of **B** if we're in class **B.**
    

In summary, these four access modifiers, in order of least to most restrictive are: public > protected > default (package-private) > private

| Class / Access Specifier | private | default | protected | public |
| --- | --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes | Yes |
| Same package | No  | Yes | Yes | Yes |
| Subclass outside of package | No  | No  | Yes | Yes |
| Unrelated class outside of package | No  | No  | No  | Yes |

# Overriding and Hiding

## Overriding

**Overriding** occurs when a subclass provides a specific implementation for a **method (not a field!)** that is already defined in its superclass.

- **Applies to Instance Methods**: Only **non-private instance methods** can be overridden.

- **Same Signature**: The method in the subclass must have the same signature as the method in the superclass.

**\- Polymorphism**: The version of the method that gets executed is determined at runtime based on the **object's runtime type**.

\- **Visibility: **The visibility of the inherited method can not be reduced.

```Java
class SuperClass {
    public void display() {
        System.out.println("Display in SuperClass");
    }
}

class SubClass extends SuperClass {
    @Override
    public void display() {
        System.out.println("Display in SubClass");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj = new SubClass();
        obj.display();  // Outputs: Display in SubClass
    }
}
```

In this example, `SubClass` overrides the `display` method of `SuperClass`. When you call `display` on a `SuperClass` reference pointing to a `SubClass` object, the overridden method in `SubClass` is executed.

## Hiding

**Hiding** refers to the scenario where a subclass declares a field or static method with the same name as an already existing static method or field in its superclass.

- **Applies to Static Methods and Fields**: Static methods and fields can be hidden, not overridden.
- **Compile-Time Binding**: The version of the static method or field that gets used is determined at compile time based on the **reference type**.

Example of static method:

```Java
class SuperClass {
    static void staticMethod() {
        System.out.println("Static Method in SuperClass");
    }
}

class SubClass extends SuperClass {
    static void staticMethod() {
        System.out.println("Static Method in SubClass");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj1 = new SuperClass();
        SuperClass obj2 = new SubClass();
        SubClass obj3 = new SubClass();

        obj1.staticMethod();  // SuperClass method
        obj2.staticMethod();  // SuperClass method, not SubClass
        obj3.staticMethod();  // SubClass method
    }
}
```

In this example, `SubClass` hides the `staticMethod` of `SuperClass`. The method called depends on the type of reference, not the object type

Example of non-static field:

```Java
class SuperClass {
    String field = "SuperClass Field";
}

class SubClass extends SuperClass {
    String field = "SubClass Field";
}

public class Main {
    public static void main(String[] args) {
        SuperClass obj1 = new SuperClass();
        SuperClass obj2 = new SubClass();
        SubClass obj3 = new SubClass();

        System.out.println(obj1.field);  
        System.out.println(obj2.field);
        System.out.println(obj3.field);
    }
}
```

Here, `SubClass` hides the `field` of `SuperClass`. For `SubClass` instances, you may understand it as they have two `field`: the `field` declared by itself and the field declared by the `SuperClass`. However, the `SuperClass`'s `field` is hidden by `SubClass`'s `field`. This is kind of similar to the case of parameter shadowing.

# Exercise

What is the output of the following program:

```Java
class A {
    protected int x = 1;

    protected void calculate() {
        x *= 2;
    }

    static protected void staticCalculate(B obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("A: " + x);
    }
}

class B extends A {
    protected int x = 2;
    protected int y = 5;

    protected void calculate() {
        x *= 2;
        y += 10;
    }

    static protected void staticCalculate(B obj) {
        obj.x *= 3;
    }

    protected void display() {
        System.out.println("B: x=" + x + ", y=" + y);
    }
}

public class Main {
    public static void main(String[] args) {
        A obj1 = new B();
        obj1.calculate();
        // obj1.staticCalculate(obj1);
        obj1.x++;
        obj1.display();

        B obj2 = new B();
        obj2.calculate();
        // obj2.staticCalculate(obj2);
        obj2.x++;
        obj2.display();
    }
}
```