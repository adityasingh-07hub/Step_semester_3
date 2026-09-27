import java.util.*;
public class FestivalBonus {
    static abstract class Employee {
        String name;
        double salary;
        Employee(String name,double salary) {
            this.name=name;
            this.salary=salary;
        }
        abstract double calculateBonus();
    }
    static class FullTime extends Employee {
        FullTime(String name,double salary) {
            super(name,salary);
        }
        double calculateBonus() {
            return salary * 0.10;
        }
    }
    static class PartTime extends Employee {
        PartTime(String name,double salary) {
            super(name,salary);
        }
        double calculateBonus() {
            return salary * 0.05;
        }
    }
    static class Intern extends Employee {
        Intern(String name,double salary) {
            super(name,salary);
        }
        double calculateBonus() {
            return 2000;
        }
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++) {
            String type=sc.next();
            String name=sc.next();
            double salary=sc.nextDouble();
            Employee emp;
            if(type.equals("FULLTIME"))
                emp=new FullTime(name,salary);
            else if(type.equals("PARTTIME"))
                emp=new PartTime(name,salary);
            else
                emp=new Intern(name,salary);
            double bonus = emp.calculateBonus();
            total+=bonus;
            System.out.printf("%s: %.2f\n", name, bonus);
        }
        System.out.printf("Total Bonus: %.2f", total);
        sc.close();
    }
}