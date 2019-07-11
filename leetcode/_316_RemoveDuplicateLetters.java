import java.util.Map;
import java.util.HashMap;

public class _316_RemoveDuplicateLetters {
    /**
     * Two pointers
     * time: O(n)
     * space: O(n)
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        char[] res = new char[map.size()];
        int start = 0, end = findMinLastPos(map);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int j = start; j <= end; j++) {
                if (map.containsKey(s.charAt(j)) && s.charAt(j) < minChar) {
                    minChar = s.charAt(j);
                    start = j + 1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(map);
            }
        }

        return new String(res);
    }
    // guarantee that all distinct letters are included
    public int findMinLastPos(Map<Character, Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int num : map.values()) {
            res = Math.min(res, num);
        }
        return res;
    }
}
