## Java Packages

In Java, packages are used to organize and group related classes and interfaces into a hierarchical directory structure. A package consists of a collection of classes and sub-packages, organized in a directory structure that matches the package names.

## Create a Java package

1.  **Create a directory for your package** \- Choose a name for your package and create a directory with that name. For example, if you want to create a package named `myPackage`, create a directory named `myPackage`.
2.  **Create your Java classes** \- Create your Java classes and save them in the directory you created in step 1. Make sure that each class has a package statement at the beginning, specifying the name of your package. For example, if you created a class named `MyClass`, the package statement should be:

```java
package myPackage;
```

**Example:**

Let's say you want to create a package called `myPackage` and place a class named `Class1` in it. You should follow these steps:

1. Create the directory structure

```css
Main.java
myPackage
└── Class1.java
```

2. In your `Class1.java` file, add the package declaration:

```Java
package myPackage;

public class Class1 {
    // implementation of Class1
    public void myMethod()
    {
    	// do something here
    }
}

class Class2{ 
    // implement something here
}
```

Note: if you have multiples classes within `Class1.java`, there should be only one public class and its name should be consistent with the file name.

## Use a Java package

To use the class of your package in `Main.java`, you may call it through namespace like this

```Java
Class1 myObject = new myPackage.Class1();
myObject.myMethod();
```

Or, you may import your classes first and then use them in your program

```java
import myPackage.Class1;

// You can then create an instance of the class and use its methods:
Class1 myObject = new Class1();
myObject.myMethod();
```

### Access Modifiers

Previously, we have talked a lot about `public` and `private` access modifiers. If you don't add any access modifier to a class/field/method, then it's what we called **default modifier (no modifier).**

Elements with no access modifier are accessible within the same package only.

| Class / Access Specifier | private | default (package - private) | public |
| --- | --- | --- | --- |
| Same Class | Yes | Yes | Yes |
| Different Class but same package | No  | Yes | Yes |
| Different Class, different package | No  | No  | Yes |

where:

- Yes indicates that the class is accessible with the access specifier
- no indicates that the class is inaccessible with the access specifier