import java.util.*;

class LabTask2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            map.put(id, map.getOrDefault(id, 0) + 1);
        }

        int product = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int id = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && id < product)) {
                maxFreq = freq;
                product = id;
            }
        }

        System.out.println(product + " " + maxFreq);
    }
}