class Objects {
    /*
      First, we learned about primitive data types:
      boolean, byte, short, int, long, float, double, char.

      Other data types are not primitive. They are said to be "objects".
      The variables corresponding to objects act as references.
      This means that primitive data types and objects
      behave quite differently and a detailed discussion is necessary.
    */
    public static void main(String[] args) {
        arrays();
        // objects();
        // functionsAndObjects();
    }

    public static void arrays() {
        /*
          ARRAYS
          To facilitate our discussion of objects,
          we need an explicit example of an object.
          In this snippet we'll use arrays.

          An array is a container object that
          holds a fixed number of values of a single type.
          The length of an array is established
          when the array is created.

          Like declarations for variables of other types,
          an array declaration has two components:
          the array's type and the variable name.

          An array's type is written as {type}[],
          where {type} is the data type of the contained elements.
          The square brackets are special symbols
          indicating that the variable references an array.
          The length of the array is not part of its type
          (which is why the brackets are empty).

          As with variables of other types,
          a declaration does not necessarily create an array;
          it simply tells the compiler that this variable
          will reference an array of the specified type.
        */

        boolean[] referenceToArrayOfBooleans;
        byte[]    referenceToArrayOfBytes;
        short[]   referenceToArrayOfShorts;
        int[]     referenceToArrayOfInts;
        long[]    referenceToArrayOfLongs;
        float[]   referenceToArrayOfFloats;
        double[]  referenceToArrayOfDoubles;
        char[]    referenceToArrayOfChars;
        String[]  referenceToArrayOfStrings;


        // To create an array, we need the 'new' keyword.
        referenceToArrayOfInts = new int[8];  // for (int v : referenceToArrayOfInts) { System.out.println(v); }
        // If you directly print out referenceToArrayOfInts, 
        // you print out a certain hexadecimal number 
        // that marks the address of the array in the memory in your computer.
        System.out.println(referenceToArrayOfInts);        
        referenceToArrayOfInts = new int[88];
        System.out.println(referenceToArrayOfInts);
        referenceToArrayOfInts = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(referenceToArrayOfInts);

        /*
          The first line:
           - creates a new array of 8 ints all of which have the value 0;
           - has referenceToArrayOfInts reference this newly created array.

          The second line:
           - creates a new array of 88 ints all of which have the value 0;
           - has referenceToArrayOfInts reference this newly created array.
             Recall that the lengths of all the arrays involved are fixed.
             The variable, however, has now referenced
             two differents arrays of different lengths.
           - The array consisting of 8 0s is no longer referenced and
             is elligible for garbage collection.
             Java performs garbage collection when it feels like it.
             Exactly when such garbage collection is performed
             is none of our business!!

          The third line:
           - creates a new array containing the ints 2, 3, 5, 7, 11, 13, 17, 19.
             Therefore the newly created array has a length of 8.
           - referenceToArrayOfInts references this newly created array.
           - The array consisting of 88 0s is no longer referenced and
             is elligible for garbage collection.

          One can ask for the length of an array using ".length".
          Indexing an array is done as one would expect from knowing C++.
          This allows us to 'for'-loop over the values stored in the array.

          There is also an enhanced for-loop.
          This is analogous to a range-based 'for' loop in C++.
          One cannot use it to edit the values in an array of primitives.
        */

        // Print values of an array using a standard 'for'-loop
        for (int i = 0; i < referenceToArrayOfInts.length; ++i) {
            System.out.print(referenceToArrayOfInts[i] + " ");
        }
        System.out.print('\n');

        // Print values of an array using an enhanced 'for'-loop
        for (int val : referenceToArrayOfInts) {
            System.out.print(val + " ");
        }
        System.out.print('\n');

        // Edit values of an array using a standard 'for'-loop
        for (int i = 0; i < referenceToArrayOfInts.length; ++i) {
            referenceToArrayOfInts[i] += 1;
        }

        // Print values of an array using an enhanced 'for'-loop
        for (int val : referenceToArrayOfInts) {
            System.out.print(val + " ");
        }
        System.out.print('\n');

        // Try and fail to edit values of an array using an enhanced 'for'-loop
        for (int val : referenceToArrayOfInts) {
            val += 1;
        }

        // Print values of an array using an enhanced 'for'-loop
        for (int val : referenceToArrayOfInts) {
            System.out.print(val + " ");
        }
        System.out.println('\n');




        // We can use an array of arrays.
        String[] salutations = new String[] { "Dear", "Hello", "Hi", "Hey", "To whom it may concern" };  
        // you can actually omit new String[] in the initializer list, i.e., you can use
        // String[] salutations =  { "Dear", "Hello", "Hi", "Hey", "To whom it may concern" };
        String[] titles = new String[] { "Professor", "Dr.", "Mr.", "Ms.", "Mx.", "Sir", "Madam", "Mer", "" };

        String[][] start_of_email = new String[2][];
        start_of_email[0] = salutations;
        start_of_email[1] = titles;

        // One could write the following instead of the proceding 3 lines...
        // String[][] start_of_email = new String[][] { salutations, titles };

        // One could write the following instead of the proceding 5 uncommented lines...
        // String[][] start_of_email = new String[][] {
        //     { "Dear", "Hello", "Hi", "Hey", "To whom it may concern" },
        //     { "Professor", "Dr.", "Mr.", "Ms.", "Mx.", "Sir", "Madam", "Mer", "" }
        // };

        // int[][] square = new int[][] {{1,2,3},{4,5,6},{7,8,9}};


        // Notice...
        System.out.print(start_of_email[0].length != start_of_email[1].length);
        System.out.println('\n');


        // A silly example of a 'for' loop over all reasonable combinations...
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.println(start_of_email[0][i] + " " + start_of_email[1][j]);
            }
        }
        System.out.print(start_of_email[0][4] + " " + start_of_email[1][8]);
        System.out.println('\n');



        // java.util.Arrays contains useful static member functions.
        // https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

        int[] arr0 = new int[] {0,  1,  2,  3,  4,  5,  6,  7};
        int[] arr1 = new int[] {0,  1,  2,  3,  4,  5,  6,  7};
        int[] arr2 = new int[] {0, 11, 22, 33, 44, 55, 66, 77};

        System.out.println(arr0 == arr1);     // false! (since different arrays are referenced)
        System.out.println(arr1 == arr2);
        System.out.println(java.util.Arrays.equals(arr0, arr1));
        System.out.println(java.util.Arrays.equals(arr1, arr2));
        System.out.print('\n');


        java.util.Arrays.fill(arr0, 8);       // replace all values by 8
        java.util.Arrays.fill(arr1, 2, 6, 8); // replace from index 2 up to, not including, index 6

        System.out.println(java.util.Arrays.toString(arr0)); // toString formats nicely
        System.out.println(java.util.Arrays.toString(arr1));
        System.out.print('\n');


        java.util.Arrays.sort(arr1, 4, 8);                   // sort from index 4 up to, not including, index 8
        System.out.println(java.util.Arrays.toString(arr1));

        java.util.Arrays.sort(arr1);                         // sort everything
        System.out.println(java.util.Arrays.toString(arr1));

        System.out.print('\n');


        int[] arr3 = java.util.Arrays.copyOf(arr2, 4);       // copies first 4 elements
        int[] arr4 = java.util.Arrays.copyOf(arr2, 8 + 4);   // copies all elements and creates 4 zeros.

        System.out.println(java.util.Arrays.toString(arr3));
        System.out.println(java.util.Arrays.toString(arr4));
    }


    public static void objects() {
        /*
          OBJECTS
          Now that we have arrays, we can highlight subtle issues involving objects.
          All of these examples stem from the fact that variables *reference* objects.
        */

        int[]   x;     int[] y;
        int[][] outer; int[] inner;
        int[]   out;   int   in;

        // EXAMPLE 1
        x = new int[] {1};              // new object created, x references it
        y = new int[] {1};              // new object created, y references it
        y[0] = 2;
        System.out.println("EAMPLE 1");
        System.out.println(x[0]);

        // EXAMPLE 2
        x = new int[] {1};              // new object created, x references it
        y = x;                          // y references the same object as x
        y[0] = 2;
        System.out.println("EAMPLE 2");
        System.out.println(x[0]);

        // EXAMPLE 3
        x = new int[] {1};              // new object created, x references it
        y = x;                          // y references the same object as x
        y = new int[] {2};              // new object created, y references it
        System.out.println("EAMPLE 3");
        System.out.println(x[0]);

        // EXAMPLE 4
        outer = new int[][] { {1, 2}, {1, 2} };    // 2 new objects created, one storing a reference to the other
        inner = outer[0];               // no new objects created
        inner[0] = 2;                   // edits one of the objects created originally
        // System.out.println(outer);
        // System.out.println(inner);
        System.out.println("EAMPLE 4");
        System.out.println(java.util.Arrays.toString(outer[0]));
        System.out.println(java.util.Arrays.toString(outer[1]));

        // EXAMPLE 5
        out = new int[] {1};            // new object created, 'out' references it
        in = out[0];                    // 'in' is primitive and copies an int
        in = 2;                         // 'in' has its value changed
        System.out.println("EAMPLE 5");
        System.out.println(out[0]);

        // EXAMPLE 6
        x = new int[] {1};              // new object created, x references it
        y = new int[] {1};              // new object created, y references it
        System.out.println("EAMPLE 6");
        System.out.println(x != y);     // true since x and y reference different objects

        // EXAMPLE 7
        x = new int[] {1};              // new object created, x references it
        y = x;                          // y references the same object as x
        System.out.println("EAMPLE 7");
        System.out.println(x == y);     // true since x and y reference the same object
    
    }


    public static void functionsAndObjects() {
        /*

          A simplified summary of that discussion in JAVA goes as follows.


          Suppose a function definition reads as follows.

          public static double f(int param1, int[] param2) {
              {body involving variable called 'forReturn'}
              return forReturn;
          }


          Suppose we call that function as follows.

          d = f(arg1, arg2);


          We can write code that is (almost) equivalent to this as follows...

          // introduce function scope
          {
              // assign arguments to corresponding parameters
              int param1 = arg1; int[] param2 = arg2;

              // "parameters" are what appear in a function definition
              // "arguments" are what are given to a function when it is called

              // {exactly what the body of f says}

              // use the return value to initialize what the function call is assigned to
              d = forReturn;

          // return statements end a function call
          // when a function call ends, the function scope is destroyed
          }

          The definitions of f1, f2, f3, g, and h are given below.
        */

        int[] arr = new int[] {0};
        System.out.println(arr[0]);

        f1(arr);                              // changes the object referenced by arr
        System.out.println("Output of f1");
        System.out.println(arr[0]);

        f2(arr);                              // does not change the object referenced by arr
        System.out.println("Output of f2");
        System.out.println(arr[0]);

        f3(arr);                              // only the first line of the body of f3 affects
        System.out.println("Output of f3");
        System.out.println(arr[0]);           // the object referenced by arr

        int i = 0;
        arr[0] = 0;

        System.out.println(i + " " + arr[0]);
        System.out.println("Output of g ");
        g(i, arr);                            // i is not changed; object referenced by arr is changed
        System.out.println(i + " " + arr[0]);

        // One can return references to objects.
        // Any object reference can reference an object called 'null'.
        System.out.println("Output of h ");
        arr = h(8);  System.out.println(java.util.Arrays.toString(arr));
        arr = h(0);  System.out.println(java.util.Arrays.toString(arr));
        arr = h(-8); System.out.println(java.util.Arrays.toString(arr));
    }

    public static void f1(int[] a) {
        a[0] = 8;                             // changes the object that 'a' references
    }
    public static void f2(int[] a) {
        a = new int[] {88};                   // has 'a' reference a new object
    }
    public static void f3(int[] a) {
        a[0] = 888;                           // changes the object that 'a' references
        a = new int[] {8888};                 // has 'a' reference a new object
    }
    public static void g(int prim, int[] ref) {
        prim = 8;                             // changes the value of prim
        ref[0] = 8;                           // changes the object that ref references
    }
    public static int[] h(int length) {
        if (length < 0) {
            return null;
        }
        return new int[length];
    }
}
