import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class _358_RearrangeStringkDistanceApart {
    /**
     * maxHeap + hashMap
     * time: O(nlogn)
     * space: O(n)
     */
    public String rearrangeString(String s, int k) {
        // keep the count of each characters in string
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // use maxHeap to sort the character by frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());
        // construct the new string
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            if (queue.size() < k)
                continue;
            // the distance is >= k, we can add the duplicate character
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }

        return res.length() == s.length() ? res.toString() : "";
    }
}
