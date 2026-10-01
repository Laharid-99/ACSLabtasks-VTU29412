import java.util.*;

class LabTask5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= a[i])
                st.pop();

            ans[i] = st.empty() ? -1 : st.peek();
            st.push(a[i]);
        }

        for (int x : ans)
            System.out.print(x + " ");
    }
}