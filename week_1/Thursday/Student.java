public class Student {
    // Declare/define data members here
    // - public data members: id, name, totalStudentCount
    // - private data members: GPA, totalGPA
    public int id;
    public String name;
    public static int totalStudentCount = 0;

    private double GPA;
    private static double totalGPA = 0.0;

    public Student(int id, String name) {
        // construtor function
        this.id = id;
        this.name = name;
        GPA = 0.0;
        totalStudentCount++;
    }

    public void updateGPA(double GPA){
        // update a student's GPA
        totalGPA = totalGPA - this.GPA + GPA;
        this.GPA = GPA;
    }

    public static double getAverageGPA(){
        // return average GPA of all students
        // Both approaches work in this case
        double averageGPA = Student.totalGPA / Student.totalStudentCount;
        // double averageGPA = totalGPA / totalStudentCount;
        return averageGPA;
    }
    public static void main(String[] args) {
        // Don't modify the main function
        Student Smith = new Student(1001, "Smith");
        Student Bob = new Student(1050, "Bob");
        
        System.out.println("We have " + Student.totalStudentCount + " now!"); // Expected output: 2

        Smith.updateGPA(3.9);
        Bob.updateGPA(3.5);

        System.out.println("The average GPA is " + Student.getAverageGPA()); // Expected output: 3.7
    }
}
