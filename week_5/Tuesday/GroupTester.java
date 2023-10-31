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

    // methods:
    // varargs constructor
    public Group(Student ... students) {
        // TODO
    }

    // groupByCourse
    public Group groupByCourse(String course){
        // TODO
        return null;
    }
    // toString for printing on console
    public String toString()
    {
        // TODO
        return "";
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