import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
public class CancelBooking {
    // Remove the first occurrence of a booking
    static Node removeFirst(Node head, String booking) {
        // If the list is empty
        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }
        // If booking is present at the head
        if (head.data.equals(booking)) {
            return head.next;
        }
        Node current = head;
        // Find the node just before the matching node
        while (current.next != null &&
               !current.next.data.equals(booking)) {

            current = current.next;
        }
        // If booking is not found
        if (current.next == null) {
            System.out.println(booking + " not found");
            return head;
        }
        // Delete the matching node
        current.next = current.next.next;
        return head;
    }
    // Display the linked list
    static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        // Enter number of bookings
        int n = sc.nextInt();
        // Create linked list
        for (int i = 0; i < n; i++) {
            String booking = sc.next();
            Node newNode = new Node(booking);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        // Enter booking number to cancel
        String booking = sc.next();
        // Remove first occurrence
        head = removeFirst(head, booking);
        // Display final linked list
        display(head);
        sc.close();
    }
}