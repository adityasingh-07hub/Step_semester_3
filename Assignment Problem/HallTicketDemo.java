public class HallTicketDemo {
    // Class representing an exam hall ticket
    static class HallTicket {
        String studentName;
        int seatNumber;
        // Constructor
        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }
    public static void main(String[] args) {
        // Create one HallTicket object
        HallTicket priya = new HallTicket("Priya", 0);
        // Both variables point to the SAME object
        HallTicket copy = priya;
        // Change the object through copy
        copy.seatNumber = 45;
        // The first reference also sees the change
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        // Check whether both references point
        // to the same object
        System.out.println( "copy == priya: " + (copy == priya));
        // Create a completely separate object
        HallTicket separate = new HallTicket("Priya", 45);
        // Same values, but different objects
        System.out.println("separate == priya: " + (separate == priya));
    }
}