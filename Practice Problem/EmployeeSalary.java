import java.util.*;
public class EmployeeSalary {
    // Parent class
    static abstract class Employee {
        String name;
        double basicSalary;
        Employee(String name, double basicSalary) {
            this.name = name;
            this.basicSalary = basicSalary;
        }
        // Common method
        abstract double calculateSalary();
    }
    // Full time employee
    static class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }
        double calculateSalary() {
            return basicSalary + (basicSalary * 0.20);
        }
    }
    // Part time employee
    static class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }
        double calculateSalary() {
            return basicSalary + (basicSalary * 0.10);
        }
    }
    // Intern employee
    static class Intern extends Employee {
        Intern(String name) {
            super(name,0);
        }
        double calculateSalary() {
            return 15000;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++) {
            String type = sc.next();
            String name = sc.next();
            Employee employee;
            if(type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                employee = new FullTime(name,salary);
            }
            else if(type.equals("PARTTIME")) {
                double salary = sc.nextDouble();
                employee = new PartTime(name,salary);
            }
            else {
                employee = new Intern(name);
            }
            double result = employee.calculateSalary();
            total += result;
            System.out.printf("%s: %.2f\n", name, result);
        }
        System.out.printf("Total Salary: %.2f", total);
        sc.close();
    }
}