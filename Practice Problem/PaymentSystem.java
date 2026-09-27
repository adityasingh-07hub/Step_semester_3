import java.util.*;
public class PaymentSystem {
    // Abstract parent class
    static abstract class Payment {
        double amount;
        Payment(double amount) {
            this.amount = amount;
        }
        // Each payment type calculates differently
        abstract double calculateAmount();
    }
    // Card payment
    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }
        double calculateAmount() {
            return amount + (amount * 0.02);
        }
    }
    // Wallet payment
    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }
        double calculateAmount() {
            return amount + (amount * 0.01);
        }
    }
    // Bank transfer
    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }
        double calculateAmount() {
            return amount;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment;
            // Create required object
            if(type.equals("CARD"))
                payment = new Card(amount);
            else if(type.equals("WALLET"))
                payment = new Wallet(amount);
            else
                payment = new BankTransfer(amount);
            double result = payment.calculateAmount();
            total += result;
            System.out.printf("%s: %.2f\n", type, result);
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}