import java.util.Map;
import java.util.HashMap;

public class _294_FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2)
            return false;

        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    public boolean helper(String s, Map<String, Boolean> map) {
        // our goals
        if (map.containsKey(s))
            return map.get(s);

        // our choices
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
