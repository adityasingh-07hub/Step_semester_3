public class StudentDemo {
    static class Student {
        // Instance variables
        String name;
        int attendance;
        // Shared variable for all objects
        static String collegeName ="SRM Institute of Science and Technology";
        // Counts number of objects created
        static int studentCount = 0;
        // Constructor
        Student(String name,int attendance) {
            this.name = name;
            this.attendance = attendance;
            // Increment whenever object is created
            studentCount++;
        }
        // Static method
        // Only accesses static variables
        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }
    public static void main(String[] args) {
        // Creating two student objects
        Student s1 = new Student("Ravi",90);
        Student s2 = new Student("Anitha",85);
        // Calling using class name
        Student.printCollegeInfo();
    }
}