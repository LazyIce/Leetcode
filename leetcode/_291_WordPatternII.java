import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class _291_WordPatternII {
    /**
     * Backtracking
     * time: TBD
     * space: O(n)
     */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>(); // whether the string in the value of map duplicates
        return helper(pattern, str, 0, 0, map, set);
    }

    public boolean helper(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set) {
        // our goals
        if (i == pattern.length() && j == str.length())
            return true;
        if (i == pattern.length() || j == str.length())
            return false;

        char c = pattern.charAt(i);
        // the character appears before in pattern
        if (map.containsKey(c)) {
            String temp = map.get(c);
            if (!str.startsWith(temp, j))
                return false;
            return helper(pattern, str, i + 1, j + temp.length(), map, set);
        }
        // our choices
        for (int k = j; k < str.length(); k++) {
            String temp = str.substring(j, k + 1);
            if (set.contains(temp))
                continue;
            map.put(c, temp);
            set.add(temp);
            if (helper(pattern, str, i + 1, k + 1, map, set))
                return true;
            map.remove(c);
            set.remove(temp);
        }

        return false;
    }
}
