import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class _269_AlienDictionary {
    /**
     * Topology sort + BFS
     * time: O(n*max length of word in words)
     * space: O(1)
     */
    public static String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";

        StringBuilder res = new StringBuilder();
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        int count = 0;
        // count the #alphabet in the dictionary
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] == -1) {
                    count++;
                    indegree[c - 'a'] = 0;
                }
            }
        }
        // calculate the indegree of each alphabet
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {
                        indegree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }
        // BFS to sort, each time get the alphabet whose indegree is 0
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                queue.offer((char)('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--indegree[ch - 'a'] == 0) {
                        queue.offer(ch);
                    }
                }
            }
        }

        if (res.length() != count)  // corner case, not all the alphabets are extracted
            return "";
        return res.toString();
    }
}
