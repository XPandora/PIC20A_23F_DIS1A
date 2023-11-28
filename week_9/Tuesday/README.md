# Nested Classes

Nested classes in Java are a powerful feature that allows you to logically group classes that are only used in one place, thus increasing encapsulation and readability of your code.

### Characteristics of Inner Classes:

1.  **Access to Members of Outer Class**: Inner classes can access both static and non-static members (fields and methods) of the outer class, even if they are declared private. This close relationship allows inner classes to interact directly with the data of the outer class.
2.  **Instance-specific**: Each instance of an inner class is associated with an instance of the outer class. To instantiate an inner class, you must first have an instance of the outer class.

```Java
class OuterClass {
    private int outerVar = 10;

    class InnerClass {
        void display() {
            System.out.println("Outer var value: " + outerVar);
        }
    }

    void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // Alternatively, call a method of OuterClass to create and use the inner class
        outer.createInner();
    }
}
```

Note: If the outer class contains a member that is an instance of an inner class, the outer class can access the private members of this inner class instance. This scenario is a bit of an exception to the typical access rules in Java.

```Java
class OuterClass {
    InnerClass innerInstance = new InnerClass();

    class InnerClass {
        private int innerVar = 20;

        private void innerMethod() {
            System.out.println("Inner method");
        }
    }

    void outerMethod() {
        // Accessing private members of inner class instance
        System.out.println("Accessing innerVar: " + innerInstance.innerVar);
        innerInstance.innerMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}
```

### Exercise:

A **linked list** is a sequence of nodes that contain two fields: data (an integer value here as an example) and a link to the next node. The last node is linked to a terminator used to signify the end of the list.

![4566d669ac79800f6ac4311160811e09.png](../_resources/4566d669ac79800f6ac4311160811e09.png)

Please finish the **add** method of the class **LinkedList**

```Java
class LinkedList {
  private Node head;
  public LinkedList() {
    head = null;
  }

  public void add(int data) {
    // TODO: add a new node to the linked list
    }
  }

  public void print() {
    Node node = this.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  private class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }
}

public class LinkedListMain {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    list.print();
  }
}
```

# GUI

Java provides several standard libraries for creating Graphical User Interfaces (GUIs). The two primary libraries are Abstract Window Toolkit (AWT) and Swing, which are part of the Java Foundation Classes (JFC).

### Abstract Window Toolkit (AWT)

AWT is one of the original Java libraries for GUI development. It provides a set of basic GUI components, a framework for managing layout, events, and graphics, as well as interfaces for accessing native system capabilities.

It includes components like buttons (`Button`), text fields (`TextField`), labels (`Label`), and panels (`Panel`).

**Swing**

Swing is a more advanced and flexible GUI toolkit that's part of the JFC. It's built on top of AWT and offers a richer set of components.

Swing provides a wide array of components like `JButton`, `JTextField`, `JLabel`, and `JPanel`, along with more complex components like `JTable`, `JTree`, and `JComboBox`.

## JFrame&JPanel

`JFrame` and `JPanel` are two fundamental classes used in Java Swing for creating graphical user interfaces (GUIs).

- `JFrame` is a top-level container used to represent the main window of a Swing-based GUI application. It typically contains the main components of the application's user interface.
- `JPanel` is a generic lightweight container. It's used to group together components or provide a specific layout within a section of the GUI. A single `JFrame` can have multiple `JPanels` (think of the editor, terminal and filetree in vscode)

Below is a simple example to create a GUI:

```Java
import javax.swing.JFrame;

public class MyFrame {
    public static void main(String[] args) {
        // Create a JFrame object
        JFrame frame = new JFrame("My First Frame");

        // Set the default operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame size
        frame.setSize(300, 200);

        // Make the frame visible
        frame.setVisible(true);
    }
}
```

To create your customized panel, you can extend the `JPanel` class and override **paintComponent. **By calling methods of **Graphics, **one can draw various types of shapes within this panel, e.g. rectangles and ovals. See SmilingFaceMain.java for details.