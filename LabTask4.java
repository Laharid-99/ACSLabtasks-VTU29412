import java.util.*;

class LabTask4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<')
                st.push(c);
            else {
                if (st.empty() ||
                    (c == ')' && st.pop() != '(') ||
                    (c == ']' && st.pop() != '[') ||
                    (c == '}' && st.pop() != '{') ||
                    (c == '>' && st.pop() != '<')) {
                    System.out.println("INVALID");
                    return;
                }
            }
        }

        System.out.println(st.empty() ? "VALID" : "INVALID");
    }
}