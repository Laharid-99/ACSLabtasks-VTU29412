import java.util.*;

class LabTask6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(map.values());

        int time = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int slots = k + 1;

            while (slots-- > 0 && !pq.isEmpty()) {
                int x = pq.poll() - 1;
                if (x > 0)
                    temp.add(x);
                time++;
            }

            pq.addAll(temp);

            if (!pq.isEmpty() && slots > 0)
                time += slots;
        }

        System.out.println(time);
    }
}