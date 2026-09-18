public class EmployeeCompanyDemo {
    static class Employee {
        // Instance variables
        String empName;
        double salary;
        // Static variable shared by all employees
        static String companyName = "Bright Horizon Technologies";
        // Static counter
        static int employeeCount = 0;
        // Constructor
        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            // Increase count whenever an object is created
            employeeCount++;
        }
        // Static method
        // It accesses only static variables
        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }
    public static void main(String[] args) {
        // Create three Employee objects
        Employee e1 = new Employee("Ravi", 40000);
        Employee e2 = new Employee("Priya", 50000);
        Employee e3 = new Employee("Arjun", 45000);
        // Call static method using class name
        Employee.printCompanyInfo();
    }
}