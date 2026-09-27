import java.util.*;
public class FoodDelivery {
    // Parent class
    static abstract class Delivery {
        double amount;
        Delivery(double amount) {
            this.amount = amount;
        }
        abstract double calculateCharge();
    }
    // Standard delivery
    static class Standard extends Delivery {
        Standard(double amount) {
            super(amount);
        }
        double calculateCharge() {
            return 50;
        }
    }
    // Express delivery
    static class Express extends Delivery {
        Express(double amount) {
            super(amount);
        }
        double calculateCharge() {
            return 100;
        }
    }
    // Prime delivery
    static class Prime extends Delivery {
        Prime(double amount) {
            super(amount);
        }
        double calculateCharge() {
            return 0;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Delivery delivery;
            if(type.equals("STANDARD"))
                delivery = new Standard(amount);
            else if(type.equals("EXPRESS"))
                delivery = new Express(amount);
            else
                delivery = new Prime(amount);
            double charge = delivery.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f\n", type, charge);
        }
        System.out.printf("Total Charge: %.2f", total);
        sc.close();
    }
}