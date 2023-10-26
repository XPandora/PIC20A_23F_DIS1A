class Student {
    // fields: name, id, courses
    public String name;
    public String id;
    public String[] courses;

    // constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // addCourse method
    public void addCourses(String... courses) {
        this.courses = courses; // this is a shallow copy!!

        // below is a deep copy
        this.courses = new String[courses.length];
        for (int i = 0; i < courses.length; ++i) {
            this.courses[i] = courses[i];
        }

    }

    // toString method
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Course list: " + java.util.Arrays.toString(courses);
    }
}

public class StudentTester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("John", "123");
        Student s2 = new Student("Eric", "124");

        String[] courseList = { "English", "History", "Mathematics" };
        s1.addCourses(courseList);
        courseList[0] = "Chemistry";
        s2.addCourses(courseList);

        System.out.println(s1);
        System.out.println(s2);
    }
}