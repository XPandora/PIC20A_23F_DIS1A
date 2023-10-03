# Introduction

Welcome to PIC 20A!

## About me

I'm Tianyi Xie, a first-year PhD student in Computer Science (I also got my CS Master degree here at UCLA several months ago). My research focus is physics-based simulation, trying to simulate different types of materials in computers.

## Contact me

- Email: tianyixie77@ucla.edu
- Discussion section: Tuesday& Thursday, 1:00 PM - 1:50 PM, Boelter 9436, **in-person**
- Office hour: Wednesday, 10:20 AM - 12:20 PM, PIC lab (MS 2000)

## Important facts

- In PIC 20A, TAs **do not** grade homework. I cannot help you if you feel you have been graded unfairly. I do not process regrade requests. You can either talk to the Prof. or do a regrade request.
- Most frequently, your code will be graded by running test cases. In this scenario, **if your code does not compile**, no test cases can be run and **you may probably receive 0 points.**

## Structure of discussion section

- Review the content covered in last one or two lectures
- Work on some exercises to help you understand and practice
    - You will first have some time to write and test your own codes and you may discuss with your classmates
    - I will then show you my solution

# Installing VS code & JDK

## VS code installation

Go to the website: https://code.visualstudio.com/download, and choose one to download based on your computer's system.

You may just use the default setting when running the installation package.

## JDK

### JVM, JRE&JDK

Three abbreviations you’ll see when installing Java are JVM(Java Virtual Machine), JRE (Java Runtime Environment) and JDK (Java Development Kit).

The JVM is an abstract machine that **provides an environment in which Java bytecode can be executed**. It interprets the bytecode and translates it into machine-specific instructions, allowing Java code to run on any platform that has a JVM installed. The JVM also manages memory, provides security features, and performs other tasks to ensure that Java programs run correctly and efficiently.

The JRE is a subset of the JDK and **provides the minimum set of tools required to run Java application**s. It includes the JVM (Java Virtual Machine), which is responsible for executing Java bytecode. Without a JRE, you wouldn’t be able to run Java code.

The JDK **includes a copy of the JRE, plus the Java compiler** (and other programmer-specific tools). Most people don’t need the JDK, since they only run compiled Java programs. But we’re going to be compiling programs ourselves, so we should install the JDK. With JDK, the java code can be compiled into bytecode.

One benefit of Java: **compile once, run anywhere**! (as long as JRE/JDK is correctly installed on your computer)

### JDK installation

- After opening Visual Studio Code, select “Extensions” from the left hand side (the 5-th icon down at the time of writing).
- Search for and install “Extension Pack for Java”.
- After the install is complete, you’ll be prompted to install JDK. (If you’re not prompted to do so, you can go to “View” (at the top), followed by “CommandPalette...”, and type “Java: Install New JDK”.)
- Then you will be asked to determine some of the settings of JDK. You can choose as suggested by the following:
    - We’re happy with Adoptium’s Temurin.
    - Select Version 11 (LTS).
    - For JVM, we’re fine with Hotspot.
- After the install, restart Visual Studio Code.
- You can check your installation by: selecting “Terminal”(at the top), followed by “New Terminal”, and typing java -version. Hopefully you’ll see...

```Java
openjdk version "11.0.18" 2023-01-17
OpenJDK Runtime Environment Temurin-11.0.18+10 (build 11.0.18+10)
OpenJDK 64-Bit Server VM Temurin-11.0.18+10 (build 11.0.18+10, mixed mode)
```

# First Java program!

Create a java code file named as HelloWorld.java

```Java
// First snippet in Java

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello,world!");
        // System.out.println does what it says:
        // it prints a line to the console.
        // println means printing and then change a new line
        // you can also use print, then you do not change a new line after printing

    }
}
```

To compile and run the program, type the following command in your terminal:

```shell
javac HelloWorld.java
java HelloWorld
```