public class MessWalletDemo {
    static class MessWallet {
        // Private balance prevents direct modification
        private double balance;
        // Constructor
        MessWallet(double balance) {
            if(balance < 0) {
                System.out.println("Warning: Negative balance not allowed");
                this.balance = 0;
            }
            else {
                this.balance = balance;
            }
        }
        // Add money to wallet
        public void topUp(double amount) {
            if(amount <= 0) {
                System.out.println("Invalid top-up amount");
                return;
            }
            balance += amount;
        }
        // Deduct money from wallet
        public void deduct(double amount) {
            if(amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }
        // Read-only access
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}