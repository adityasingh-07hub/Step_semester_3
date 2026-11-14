import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
class Stack {
    Node top;
    int size;
    Stack() {
        top = null;
        size = 0;
    }
    // Insert a plate at the top
    void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }
    // Remove the top plate
    void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }
        String removed = top.data;
        top = top.next;
        size--;
        System.out.println("pop -> " + removed + ", size " + size);
    }
    // Display the top plate
    void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }
    // Check whether stack is empty
    boolean isEmpty() {
        return top == null;
    }
    int getSize() {
        return size;
    }
}
public class PlateStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        // Number of operations
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String operation = sc.next();
            switch (operation) {
                case "push":
                    String plate = sc.next();
                    stack.push(plate);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "peek":
                    stack.peek();
                    break;
                case "isEmpty":
                    System.out.println("isEmpty -> " +
                            stack.isEmpty());
                    break;
            }
        }
        sc.close();
    }
}