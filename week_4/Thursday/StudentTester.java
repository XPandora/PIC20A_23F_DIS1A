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