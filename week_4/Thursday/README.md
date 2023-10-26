# Creating Class Instances

1. **Using the `new` Operator:**

The most common way to create an object is by using the `new` operator followed by a constructor. Constructors do not have a return type and its name should be consistent with the class name.

```Java
public class Person {
    // Fields (data members)
    public String name;
    public int age;

    // Methods
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person(String name){
    	this(name, 20);
    }
}
```

You can write multiples versions of constructors as long as their parameter lists are different, which is essentially overloading.

Note: Besides preventing variable shadowing, the `this` keyword can be used to call another constructor within the same class. This is known as constructor chaining.

2. **Using Factory Methods:**

It is usually a public static method in a class responsible for creating and returning instances of that class or its subclasses based on a set of provided parameters or conditions. The Factory Method design pattern promotes loose coupling and flexibility in object creation by allowing the choice of which class to instantiate to be made at runtime. We will talk about this in the future.

```Java
public class Person {
    // Fields (data members)
    public String name;
    public int age;

    // Factory Method
    public static Person newBaby(String name)
    {
    	Person baby = new Person();
    	baby.name = name;
    	baby.age = 0;
    	
    	return baby;
    }
}
```

# Modifier Keywords

## Access Modifiers

Access modifiers determine the visibility and accessibility of classes, methods, and fields. Java provides four access modifiers:

- **public:** Elements with this modifier are accessible from anywhere, both within and outside the package. For example, a public method can be called from any other class.
    
- **private:** Elements with this modifier are accessible only within the same class. They are not visible to other classes, even within the same package.
    
- **protected:** Elements with this modifier are accessible within the same class, within the same package, and by subclasses, even if they are in a different package.
    
- **default (no modifier):** Elements with no access modifier are accessible within the same package only. If no access modifier is specified, the default access is applied.
    

Note: Another interesting feature of private is that making a constructor function private can prevent users from instantiating a class. This is a useful safety feature for utility classes.

## Non-Access Modifiers:

Non-access modifiers are used to modify the behavior of classes, methods, fields, and other elements. Some common non-access modifiers include:

- **static:** When applied to fields, methods, or inner classes, it makes them belong to the class rather than to a specific instance. For example, static fields are shared by all instances of a class. When applied to inner classes, it means they are not associated with any specific instance of the outer class.
    
- **final:** When applied to classes, fields, or methods, it indicates that they cannot be extended, modified, or overridden, respectively. For example, final classes cannot have subclasses, final fields cannot be changed after initialization, and final methods cannot be overridden in subclasses.
    

# toString Method

In Java, the `toString` method is a method defined in the `Object` class, and it is overridden by other classes to provide a human-readable string representation of an object. The purpose of this method is to allow you to create a custom string representation of an object's state, making it easier to display information about the object or for debugging purposes.

The `Object` class defines the `toString` method as follows:

```Java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

By default, the `toString` method returns a string that consists of the class name and the object's hash code in hexadecimal format. Something related to the memory address of this object.

However, it is common practice to override the `toString` method in your own classes to provide a meaningful and human-readable representation of the object's state. Here's how you can override the `toString` method in your class:

```Java
public class Person {
    // Fields (data members)
    public String name;
    public int age;

    // ...other Methods
    
    // override default toString Method
    public String toString()
    {
    	return "name: "+ name + ", age: " + age;
    }
    
    public static void main(String[] string)
    {
    	Person person = new Person("John", 18);
    	System.out.println(person); // this will call the toString function of Person   
    }
}
```

The `toString` method is often used in debugging and logging scenarios to provide more informative output about objects, making it easier to understand their current state.

# Exercise

Write a Student class with the following details:

- Attributes/fields
    - name
    - id
    - courses
- Behavior/methods
    - constructor
        - paramters - name, id
    - addCourses
        - parametes - varargs courses
    - toString

Finally, write a StudentTester class that:

- creates an instance of a student
- adds courses to the student, which should do a deep copy (create a new array object)
- prints the student details

```Java
class Student {
    // fields: name, id, course


    // constructor

    // addCourse method

    // toString method
}

public class StudentTester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("John","123");
        Student s2 = new Student("Eric","124");
        
        String[] courseList = {"English", "History", "Mathematics"};
        s1.addCourses(courseList);
        courseList[0] = "Chemistry";
        s2.addCourses(courseList);

        System.out.println(s1);
        System.out.println(s2);
    }
}
```