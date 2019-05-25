import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    /**
     * time complexity: O(n)
     * sapce complexity: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // Keep the value and index of the characters
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {   // Move right pointer
            char cur = s.charAt(i);
            // if repeating character appears
            if (map.containsKey(cur)) {
                maxLen = Math.max(i - j, maxLen);
                j = Math.max(j, map.get(cur) + 1);   // Move left pointer.
            }
            map.put(cur, i);
        }
        return Math.max(s.length() - j, maxLen);
    }
}
