import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
public class LateComers {
    // Add a student at the beginning
    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        head = newNode;
        return head;
    }
    // Add a student at the end
    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        // If the line is empty
        if (head == null) {
            return newNode;
        }
        Node current = head;
        // Move to the last node
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
    // Display the final line
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
        // Enter starting number of students
        int n = sc.nextInt();
        // Enter starting student names
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            head = addLast(head, name);
        }
        // Enter number of operations
        int operations = sc.nextInt();
        // Perform operations
        for (int i = 0; i < operations; i++) {
            String operation = sc.next();
            String name = sc.next();
            if (operation.equals("addFirst")) {
                head = addFirst(head, name);
            }
            else if (operation.equals("addLast")) {
                head = addLast(head, name);
            }
        }
        // Display final line
        display(head);
        sc.close();
    }
}