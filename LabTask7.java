import java.util.*;

class LabTask7 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build tree from level order
    static Node buildTree(int[] a) {
        if (a.length == 0 || a[0] == -1)
            return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < a.length) {
            Node current = q.poll();

            if (a[i] != -1) {
                current.left = new Node(a[i]);
                q.add(current.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                current.right = new Node(a[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Find height in edges
    static int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left),
                             height(root.right));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Node root = buildTree(a);

        int h = height(root);

        System.out.println("Height = " + h);
        System.out.println("Levels = " + (h + 1));

        sc.close();
    }
}