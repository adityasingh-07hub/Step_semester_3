import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
public class BusRoute {
    // Build the linked list
    static Node build(String[] stops) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < stops.length; i++) {
            Node newNode = new Node(stops[i]);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
    // Print the linked list
    static void printRoute(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }
        Node head = build(stops);
        printRoute(head);
        // Find count and last stop
        int count = 0;
        Node current = head;
        String last = "";
        while (current != null) {
            count++;
            last = current.data;
            current = current.next;
        }
        System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last);
        sc.close();
    }
}