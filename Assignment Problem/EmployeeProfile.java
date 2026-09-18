public class EmployeeProfile {
    static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;
        // Constructor for permanent employees
        Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            // Permanent employee
            this.isIntern = false;
        }
        // Constructor for interns
        Employee(String empId, String empName) {
            // Call the three-argument constructor
            // Salary is set to 0
            this(empId, empName, 0);
            // Change intern status
            this.isIntern = true;
        }
        // Method to print employee details
        void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }
    public static void main(String[] args) {
        // Permanent employee
        Employee permanent = new Employee("E-101", "Divya", 65000);
        // Intern
        Employee intern = new Employee("E-102", "Arjun");
        // Print both profiles
        permanent.printProfile();
        intern.printProfile();
    }
}