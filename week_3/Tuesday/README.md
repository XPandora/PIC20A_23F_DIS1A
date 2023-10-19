# Memory Layout

In a typical computer system, memory is organized into different segments, with two primary segments being the **stack** and the **heap.**

**<img src="_resources/ca65aa85921c97b91c7662e3f6b38b79.png" alt="ca65aa85921c97b91c7662e3f6b38b79.png" width="261" height="268" class="jop-noMdConv">**

**Stack:**

- The stack is a region of memory that stores data in a last-in, first-out (LIFO) fashion. This means that the most recently added item is the first to be removed.
- It is primarily used for storing function call information (e.g., local variables, function parameters, return addresses). For example, `int a = 0`, and `a` is stored in stack.
- The stack is typically located at the higher addresses and grows downwards.

**Heap**

- The heap is a region of memory used for dynamic memory allocation, where you can allocate memory during runtime.
- It is less structured than the stack and does not have a specific order for allocating or deallocating memory.
- Accessing heap memory involves using pointers to find the specific location of data.
- The heap is typically located at the lower addresses and grows upwards.

# Objects in Java

When an object is created in Java, memory is allocated on the heap to hold the object's data, and the return value is the reference of that object, which is usually stored in stack.

```java
MyClass obj;
obj = new MyClass();
```

The reference variable now points to the memory location of the newly created object on the heap:

```
   Stack               Heap
+--------+      +----------------+
|  obj   |      | MyClass Object |
+--------+      +----------------+
|  0x100 |----> |      data      |
+--------+      +----------------+

```

When the object is no longer needed, it can be garbage collected by JVM automatically and the memory on the heap can be reclaimed:

```java
obj = null;
```

```
   Stack
+--------+
|  obj   |    
+--------+
|  null  |
+--------+
```

In most cases, in Java, references are created on the stack and objects are created on the heap. When an object is created, memory is allocated on the heap to hold the object's data, and a reference variable on the stack is assigned to point to the memory location of the object. When the object is no longer needed, it can be garbage collected and the memory on the heap can be reclaimed.

See `Objects.java`  for examples.

## Exercise

Finish the method `initializeMatrix` and `transpose` in the following code snippet:

```Java
public class Matrix {
    public static int[][] initializeMatrix(int N) {
        // initialize a N by N matrix
        // value of each element is N * row_index + col_index
        // e.g. when N=3, array should be
        // 0 1 2
        // 3 4 5
        // 6 7 8
        int[][] mat;

        return mat;
    }

    public static void transpose(int[][] mat) {
        // transpose a matrix
        // you can assume mat is a square matrix
    }

    public static void main(String[] string) {
        int N = 4;
        int[][] mat = initializeMatrix(N);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }

        transpose(mat);
        System.out.println("After transpose...");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(String.format("%3s", Integer.toString(mat[r][c])));
            }
            System.out.print("\n");
        }
    }
}
```