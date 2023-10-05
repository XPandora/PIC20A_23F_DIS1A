public class Student {
    // Declare/define data members here
    // - public data members: id, name, totalStudentCount
    // - private data members: GPA, totalGPA

    public Student(int id, String name) {
        // construtor function
    }

    public void updateGPA(double GPA){
        // update a student's GPA
    }

    public static double getAverageGPA(){
        // return average GPA of all students
        double averageGPA = 0.0;
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
