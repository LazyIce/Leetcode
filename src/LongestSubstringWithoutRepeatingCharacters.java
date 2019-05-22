import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * time: O(N)
     * space: O(N)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int j = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                maxLen = Math.max(i - j, maxLen);
                j = Math.max(j, map.get(cur) + 1);
            }
            map.put(cur, i);
        }
        return Math.max(s.length() - j, maxLen);
    }
}
