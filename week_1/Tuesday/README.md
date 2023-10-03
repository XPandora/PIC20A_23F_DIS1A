# Shell command

A shell is a special user program that provides an interface to the user to use operating system services. Shell accepts human-readable commands from the user and converts them into something which the kernel can understand. It is a command language interpreter that executes commands read from input devices such as keyboards or from files.

## File path

### Basics

- File paths identify a single **file** or **directory** on your machine
- They are used to choose the program to run (word 0 of the command line)
- Many commands take files as arguments using this syntax
- There are two kinds of paths: **relative** and **absolute**
- Relative paths can start with a name (`foo.txt` or `data/foo.txt`(mac/linux) or `data\foo.txt`(windows)).
- There are two special names to start relative paths:
    - `./foo.txt or ./dir/foo.txt` or `.\foo.txt`: `.` means “the current directory”
    - `../foo.txt` or `../../dir/foo.txt or ..\foo.txt`: `..` means “the parent directory”
- Absolute paths start with a `/` (Mac/Linux) or a drive like `C:\` (Windows)
    - `/Users/yourname/Documents/foo.txt` (Mac/Linux)
    - `C:\Users\yourname\Documents\foo.txt` (Windows)

### Current directory

- Your command shell (like all programs) has a “current directory” variable
- Relative paths are interpreted starting at the current directory
- The current directory is typically shown in your shell prompt
    - `/Users/yourname/Documents $` or `C:\Users\yourname\Documents >`
    - `~/Documents`: the `~` is an abbreviation for your home folder
- Change the current directory with the `cd` (Mac/Linux/Windows)
    - `cd pic20a` or `cd /Users/yourname/pic20a/homework1/` or `cd ..`

## Other useful commands

- Show contents of current directory: `ls`
- Make a new directory: `mkdir dirname`
- Rename a file or directory: `mv oldname newname`
- Delete a file: `rm filename`
- Delete an empty directory: `rmdir dirname`
- Java commands:
    - Compiler: `javac HelloWorld.java`
    - Runtime: `java HelloWorld`

Check out more basic shell commands:

- Linux/mac: https://www.geeksforgeeks.org/basic-shell-commands-in-linux/
- Windows: https://www.stationx.net/windows-command-line-cheat-sheet/

You don't have to remember all these shell commands, but it's good to keep those frequently used commands in your mind.

# C++ review

## Reference Parameters

Reference parameters allow a function to modify the value of a variable that was passed to it as an argument. When a variable is passed by reference (usually marked as **&**), the function can modify **the original value** of the variable, rather than creating a copy of it. This can be useful in cases where you want to avoid copying large objects or when you need to modify the value of a variable within a function.

Here's an example of a function that takes a reference parameter:

```c++
#include <iostream>

void increment_copy(int x) {
    x++;
    std::cout << x << std::endl;
}

void increment_ref(int& x) {
    x++;
    std::cout << x << std::endl;
}

int main() {
    int a = 10;
    increment_copy(a);
    std::cout << a << std::endl;
    increment_ref(a);
    std::cout << a << std::endl;
    return 0;
}
```

What's the output of this program?

In this example, the increment\_copy functions takes a copy of integer parameter as input while the increment\_ref function takes an integer reference parameter. When a is passed to the increment_ref function, the function modifies the original value of a by incrementing it.

## Classes

Classes are user-defined data types that encapsulate data and functions. They are used to model real-world objects and provide a way to group related data and functions together. Classes can have **member variables** (also called data members) and **member functions** (also called methods). They can also have constructors and destructors, which are special member functions that are called when an object is created or destroyed.

Here's an example of a simple class in C++:

```c++
#include <iostream>

class Rectangle {
private:
    int width;
    int height;
public:
    Rectangle(int w, int h) {
        width = w;
        height = h;
        std::cout << "Constructor function is called!" << std::endl;
    }
    ~Rectangle(){
    	std::cout << "Destructor functions is called!" << std::endl;
    }
    int area() {
        return width * height;
    }
};

int main() {
    Rectangle rect(5, 10);
    std::cout << rect.area() << std::endl; // Output: 50
    return 0;
}
```

In this example, a Rectangle class is defined with private member variables width and height, and a public member function area that calculates the area of the rectangle. A constructor is also defined to initialize the width and height of the rectangle when an object is created. In main, an object rect of type Rectangle is created with width 5 and height 10, and its area is printed to the console using the area method.

# Static Keyword

Static keyword is used for almost the same purpose in both C++ and Java. There are some differences though.

### Similarities between C++ and Java for Static Keyword:

- Static data members can be defined in both languages.
- Static member functions can be defined in both languages.
- Easy access of static members is possible, without creating some objects.

### Differences between C++ and Java for Static Keyword:

- C++ doesn’t support static blocks. Java supports static block (also called static clause). It is used for the static initialization of a class.
- Static Local Variables can be declared. Static Local Variables are not supported.

### Static Data Members

Like C++, static data members in Java are class members and shared among all objects. For example, in the following Java program, the static variable count is used to count the number of objects created.

```c++
class Test {
    static int count = 0;

    Test() { count++; }
    public static void main(String arr[])
    {
        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println("Total " + count
                        + " objects created");
    }
}
```

### Static Member Methods

In C++ and Java, static member functions can be defined. Methods declared as static are class members and have the following restrictions:

1.  They can only call other static methods. For example, the following program fails in the compilation. fun() is non-static and it is called in static main().

```java
class Main {
    public static void main(String args[])
    {
        System.out.println(fun());
    }
    int fun() { return 20; }
}
```

2.  They must only access static data.
3.  They cannot access this.
4.  Like C++, static data members and static methods can be accessed without creating an object. They can be accessed using the class names. For example, in the following program, static data member count and static method fun() are accessed without any object.

```java
class Test {
    static int count = 0;
    public static void fun()
    {
        System.out.println("Static fun() called");
    }
}

class Main {
    public static void main(String arr[])
    {
        System.out.println("Test.count = " + Test.count);
        Test.fun();
    }
}
```

Output

```
Test.count = 0
Static fun() called
```

### Static Block

Unlike C++, Java supports a special block, called static block (also called static clause) which can be used for static initialization of a class. This code inside the static block is executed only once.

### Static Local Variables

Unlike Java, C++ supports static local variables. For example, the following Java program fails in the compilation.

```java
class Test {
    public static void main(String args[])
    {
        System.out.println(fun());
    }
    static int fun()
    {

        // Compiler Error: Static local
        // variables are not allowed
        static int x = 10;
        return x--;
    }
}
```