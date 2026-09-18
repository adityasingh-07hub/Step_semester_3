public class Payroll {
    static class PayrollAccount {
        // Private variables for encapsulation
        private double basicSalary;
        private double bonus;
        // Constructor
        PayrollAccount(double basicSalary) {
            // Negative salary is not allowed
            if (basicSalary < 0) {
                System.out.println("Warning: Negative salary not allowed");
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }
            // Initially bonus is zero
            this.bonus = 0;
        }
        // Method to add bonus
        public void creditBonus(double amount) {
            // Reject zero or negative bonus
            if (amount <= 0) {
                System.out.println("Bonus rejected: amount must be positive");
                return;
            }
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
        // Method to deduct tax
        public void deductTax(double percent) {
            // Tax percentage must be between 0 and 100
            if (percent < 0 || percent > 100) {
                System.out.println("Tax rejected: invalid percentage");
                return;
            }
            // Calculate tax amount
            double tax = basicSalary * percent / 100;
            // Reduce basic salary
            basicSalary -= tax;
            System.out.println("Tax deducted: " + percent + "%");
        }
        // Getter method for net salary
        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }
    public static void main(String[] args) {
        // Create account with Rs 50000 salary
        PayrollAccount account = new PayrollAccount(50000);
        // Add Rs 5000 bonus
        account.creditBonus(5000);
        // Deduct 10% tax
        account.deductTax(10);
        // Display final salary
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}