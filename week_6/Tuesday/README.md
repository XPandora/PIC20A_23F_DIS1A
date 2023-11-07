# Inheritance

Inheritance is a mechanism in Java that allows one class (the child or subclass) to inherit the properties and behaviors (fields and methods) of another class (the parent or superclass). Inheritance promotes code reuse and the creation of a hierarchy of classes.

```Java
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); // Call the constructor of the baseclass, which has to be the first statement
    }

    public void bark() {
        System.out.println(name + " is barking.");
    }
}
```

In this example, `Dog` is a subclass of `Animal`. It inherits the `name` field and `eat` method from `Animal`. This means you can create `Dog` objects and call `eat` on them, even though `eat` is defined in the `Animal` class.

```Java
Dog dog = new Dog("Buddy");
dog.eat(); // Calls the eat method from the Animal class
dog.bark(); // Calls the bark method from the Dog class
```

### Polymorphism

Polymorphism means "many forms", and is a concept in which objects of different classes are treated as objects of a common superclass. It allows you to use a single interface to represent different classes.

```Java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}
```

In this example, `Dog` and `Cat` both inherit from `Animal` and override the `makeSound` method. Using polymorphism, you can create an array of `Animal` objects and call `makeSound` on each object, which will execute the appropriate implementation based on the actual object type.

```Java
Animal[] animals = new Animal[3];
animals[0] = new Animal();
animals[1] = new Cat();
animals[2] = new Dog();

for (Animal animal : animals) {
    animal.makeSound(); // Calls the appropriate makeSound method for each object
}
```

Output:

```Java
Some sound
Meow
Bark
```

In this example, polymorphism allows you to treat objects of different subclasses as objects of the common superclass (`Animal`). The actual method that is called at runtime depends on the type of the object, demonstrating the power of polymorphism.

**Upcasting** is when a subclass object is assigned to a superclass reference variable.

```java
Parent p = new Child(); // Upcasting is fine!
```

- Note that with upcasting, the superclass reference can only call the methods defined in the superclass and any method that were overridden will call the overridden version defined in the subclass instead of the methods in the superclass. And note that it cannot call the methods defined in the subclass object even though it is pointing to it (unless its an overridden method).
- This similar to **widening conversion**.

**Downcasting** is when a superclass reference variable is assigned to a subclass reference variable.

- Downcasting in the actual meaning of the word is not directly allowed. ie: subclass class ref points to superclass object - This is **not allowed**!!
- This is similar to **narrowing conversion**.

```java
Child c = new Parent(); // This is NOT ALLOWED!!
```

- But, if we upcast first (ie: make a superclass ref point to a subclass object) and then downcast (ie: make a subclass ref point to the casted version) - Then it is okay!

```Java
Parent p = new Child(); // Upcast first
Child c = (Child)p; // And then downcast
// This is essentially making a Child ref point to a Child object anyway
```

In summary, **inheritance** allows classes to inherit properties and behaviors from other classes, creating a hierarchy of classes. **Polymorphism** allows objects of different classes to be treated as objects of a common superclass, enabling dynamic method invocation based on the actual object type.