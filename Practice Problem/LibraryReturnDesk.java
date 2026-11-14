
import java.util.Scanner;
public class LibraryReturnDesk {
    static String[] stack = new String[3];
    static int top = -1;
    static String[] queue = new String[3];
    static int front = 0;
    static int rear = 0;
    static int size = 0;
    static void process(String command) {
        String[] parts = command.trim().split("\\s+", 2);
        if (parts.length == 0)
            return;
        String operation = parts[0].toUpperCase();
        if (operation.equals("RETURN")) {
            String book = parts[1];
            if (top == 2) {
                System.out.println(book + " rejected: pile is full");
            } else {
                stack[++top] = book;
                System.out.println(book + " placed on pile");
            }
        }
        else if (operation.equals("SHELVE")) {
            if (top == -1) {
                System.out.println("pile is empty");
            } else {
                System.out.println("shelved " + stack[top]);
                stack[top] = null;
                top--;
            }
        }
        else if (operation.equals("WAIT")) {
            String student = parts[1];
            if (size == 3) {
                System.out.println(student + " rejected: line is full");
            } else {
                queue[rear] = student;
                rear = (rear + 1) % 3;
                size++;
                System.out.println(student + " joined the line");
            }
        }
        else if (operation.equals("SERVE")) {
            if (size == 0) {
                System.out.println("no one waiting");
            } else {
                System.out.println("served " + queue[front]);
                queue[front] = null;
                front = (front + 1) % 3;
                size--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.useDelimiter("\\\\A").hasNext() ? sc.next() : "";
        String[] commands = input.split("[,\\r\\n]+");
        for (String command : commands) {
            if (!command.trim().isEmpty()) {
                process(command);
            }
        }
        sc.close();
    }
}