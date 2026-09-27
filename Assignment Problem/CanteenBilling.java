import java.util.*;
public class CanteenBilling {
    // Abstract class defining common operation
    static abstract class Customer {
        double amount;
        Customer(double amount) {
            this.amount = amount;
        }
        // Each customer type implements differently
        abstract double calculateAmount();
    }
    // Student customer
    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }
        double calculateAmount() {
            // 10% discount
            return amount - (amount * 0.10);
        }
    }
    // Staff customer
    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }
        double calculateAmount() {
            // 5% discount
            return amount - (amount * 0.05);
        }
    }
    // Guest customer
    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }
        double calculateAmount() {
            // Full amount + service charge
            return amount + 10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer;
            // Create required object
            if(type.equals("STUDENT"))
                customer = new Student(amount);
            else if(type.equals("STAFF"))
                customer = new Staff(amount);

            else
                customer = new Guest(amount);
            double finalAmount =
                    customer.calculateAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f\n", type, finalAmount);
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}