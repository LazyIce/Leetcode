import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();
        Map<Character, Integer> cm = new HashMap<Character, Integer>();
        int j = 0, maxLen = 0;
        for(int i = 0; i < sc.length; ++i) {
            char cur = sc[i];
            if(cm.containsKey(cur)) {
                maxLen = Math.max(i - j, maxLen);
                j = Math.max(j, cm.get(cur) + 1);
            }
            cm.put(cur, i);
        }
        return Math.max(sc.length - j, maxLen);
    }
}
