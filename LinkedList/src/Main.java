import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;
    }
    static Node head = null;
    static void reverseList() {

        // Create a stack "stack1" of Node type
        Stack<Node> stack1 = new Stack<>();
        Node temp = head;
        while (temp.next != null) {
            stack1.add(temp);
            temp = temp.next;
        }
        head = temp;
        while (!stack1.isEmpty()) {
            temp.next = stack1.peek();
            stack1.pop();
            temp = temp.next; // update the next pointer in the list
        }
        temp.next = null;
    }

    static void printList(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static void insertTail(int value) {

        Node temp = new Node();
        temp.data = value;
        temp.next = null;

        if (head == null) {
            head = temp;
        }
        else {
            Node last_node = head;
            while (last_node.next != null)
                last_node = last_node.next;
            last_node.next = temp;
        }
    }

    public static void main(String[] args)
    {
        insertTail(5);
        insertTail(2);
        insertTail(33);
        insertTail(41);
        System.out.println("Given linked list: ");
        printList(head);
        reverseList();
        System.out.println("\nReversed linked list: ");
        printList(head);
    }
}

