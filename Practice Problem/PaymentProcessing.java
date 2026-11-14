import java.util.Scanner;
interface PaymentMode {
    double processPayment(double amount);
}
class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}
class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount + (amount * 0.02);
    }
}
class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}
public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double amount = sc.nextDouble();
            amounts[i] = amount;
            if (mode.equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            } else if (mode.equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            } else if (mode.equalsIgnoreCase("UPI")) {
                payments[i] = new UpiPayment();
            }
        }
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double processed = payments[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];
            String mode = payments[i].getClass().getSimpleName().replace("Payment", "");
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n", mode, amounts[i], fee, processed);
            grandTotal += processed;
        }
        System.out.printf("Total Amount Processed: %.1f%n", grandTotal);
        sc.close();
    }
}