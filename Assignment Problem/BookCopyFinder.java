import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
public class BookCopyFinder {
    // Find first position and total copies
    static String find(Node head, String id) {
        int position = 1;
        int firstPosition = -1;
        int copies = 0;
        Node current = head;
        // Traverse the linked list once
        while (current != null) {
            if (current.data.equals(id)) {
                copies++;
                // Store only the first position
                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }
            current = current.next;
            position++;
        }
        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        // Enter number of book IDs
        int n = sc.nextInt();
        // Create linked list
        for (int i = 0; i < n; i++) {
            String bookId = sc.next();
            Node newNode = new Node(bookId);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        // Enter ID to search
        String id = sc.next();
        // Find and display result
        System.out.println(find(head, id));
        sc.close();
    }
}