import java.util.*;

class LabTask3 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Detect and remove cycle
    static void removeCycle(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // No cycle
        if (slow != fast)
            return;

        // Find cycle starting node
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Find last node of cycle
        Node cycleLast = slow;

        while (cycleLast.next != slow) {
            cycleLast = cycleLast.next;
        }

        // Remove cycle
        cycleLast.next = null;
    }

    // Reverse every K nodes
    static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1)
            return head;

        Node current = head;
        Node prev = null;

        int count = 0;

        // Reverse first k nodes
        while (current != null && count < k) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Reverse remaining nodes recursively
        if (current != null) {
            head.next = reverseKGroup(current, k);
        }

        return prev;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Node head = null;
        Node tail = null;

        Node[] nodes = new Node[n];

        // Create linked list
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            nodes[i] = new Node(value);

            if (head == null) {
                head = nodes[i];
            } else {
                tail.next = nodes[i];
            }

            tail = nodes[i];
        }

        int cyclePosition = sc.nextInt();

        // Create cycle
        if (cyclePosition != -1) {
            tail.next = nodes[cyclePosition];
        }

        // Detect and remove cycle
        removeCycle(head);

        // Reverse in K groups
        head = reverseKGroup(head, k);

        // Print repaired route
        printList(head);

        sc.close();
    }
}