import java.util.*;

class LabTask8 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    static Node build(int[] a) {
        if (a.length == 0) return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < a.length;) {
            Node p = q.poll();

            if (a[i] != -1) {
                p.left = new Node(a[i]);
                q.add(p.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                p.right = new Node(a[i]);
                q.add(p.right);
            }
            i++;
        }
        return root;
    }

    static Node lca(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b)
            return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        Node root = build(a);

        System.out.println("LCA = " + lca(root, x, y).data);
    }
}