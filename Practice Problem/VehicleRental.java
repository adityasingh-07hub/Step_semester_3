import java.util.*;
public class VehicleRental {
    // Parent class
    static abstract class Vehicle {
        int days;
        Vehicle(int days) {
            this.days = days;
        }
        abstract double calculateCost();
    }
    // Bike class
    static class Bike extends Vehicle {
        Bike(int days) {
            super(days);
        }
        double calculateCost() {
            return days * 200;
        }
    }
    // Car class
    static class Car extends Vehicle {
        Car(int days) {
            super(days);
        }
        double calculateCost() {
            return days * 500;
        }
    }
    // Truck class
    static class Truck extends Vehicle {
        Truck(int days) {
            super(days);
        }
        double calculateCost() {
            return days * 1000;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++) {
            String type = sc.next();
            int days = sc.nextInt();
            Vehicle vehicle;
            if(type.equals("BIKE"))
                vehicle = new Bike(days);
            else if(type.equals("CAR"))
                vehicle = new Car(days);
            else
                vehicle = new Truck(days);
            double cost = vehicle.calculateCost();
            total += cost;
            System.out.printf("%s: %.2f\n", type, cost);
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}