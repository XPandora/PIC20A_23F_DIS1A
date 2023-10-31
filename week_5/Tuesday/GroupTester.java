class Student {
    // fields
    public String name;
    public String id;
    public String[] courses;


    // constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // variable arguments - varargs
    public void addCourses(String ... courses)
    {
        this.courses = new String[courses.length];
        for(int i = 0; i < courses.length; i++)
        {
            this.courses[i] = courses[i]; 
        }
    }

    // toString for printing on console
    public String toString()
    {
        return "Name: " + name + ", ID: " + id + ", Courses: " + java.util.Arrays.toString(courses);
    }
}
class Group {
    // fields: array of students
    public Student[] group;

    // methods:
    // varargs constructor
    public Group(Student ... students) {
       // group = students; // this is called soft copy

       // this a deep copy
       // have to create a array, and copy the elements of array one by one
       group = new Student[students.length];
       for (int i = 0; i < students.length; i++)
       {
            group[i] = students[i];
       }
    }

    // groupByCourse
    public Group groupByCourse(String course){
        // first nested loop: counte how many students take this course
        int counters = 0;
        for (int i = 0; i < group.length; i++)
        {
            Student s = group[i]; // get the i-th student from the array of students
            // then we need to check if this student take this 'course'
            for (int j = 0; j < s.courses.length; j++)
            {
                // the first one is usually not recommeded
                // if (s.courses[j] == course) // this compare the address/reference value this two string
                if (s.courses[j].equals(course)) // this will compare the contect of string object
                {
                    counters++;
                    break;
                }
            }
        }

        // second step: create the array to be returned
        Student[] newGroup = new Student[counters];
        counters=0;
        // the second nested loop is basically the same with the first one
        // but will just copy the student element to the new array
        for (int i = 0; i < group.length; i++)
        {
            Student s = group[i]; // get the i-th student from the array of students
            // then we need to check if this student take this 'course'
            for (int j = 0; j < s.courses.length; j++)
            {
                if (s.courses[j].equals(course)) 
                {
                    newGroup[counters] = s;
                    counters++;
                    break;
                }
            }
        }

        return new Group(newGroup);
    }
    // toString for printing on console
    public String toString()
    {
        return java.util.Arrays.toString(group);
    }
}

public class GroupTester {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("John","12345");
        s1.addCourses("English", "History", "Mathematics");
        Student s2 = new Student("Peter","56789");
        s2.addCourses("Science", "English", "Economics");
        Student s3 = new Student("Elizabeth","12121");
        s3.addCourses("Science", "Art", "French");
        
        Group g1 = new Group(s1,s2,s3);
        System.out.println(g1);
        Group g2 = g1.groupByCourse("Science");
        System.out.println(g2);
    }
}