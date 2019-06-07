import java.util.List;
import java.util.ArrayList;

public class _93_RestoreIPAddresses {
    /**
     * Backtracking
     * time: O(3^n) n = 4
     * space: O(n)
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        helper(res, s, "", 0, 0);
        return res;
    }

    public void helper(List<String> res, String s, String ip, int count, int start) {
        // our constraint
        if (count > 4)
            return;
        // our goal
        if (count == 4 && start == s.length()) {
            res.add(ip);
            return;
        }
        // try 1, 2, 3
        for (int i = 1; i < 4; i++) {
            if (start + i > s.length())
                break;
            // our choice
            String str = s.substring(start, start + i);
            // our constraint
            if (str.startsWith("0") && str.length() >1 || Integer.parseInt(str) > 255)
                continue;
            helper(res, s, ip + str + (count == 3 ? "" : "."), count + 1, start + i);
        }
    }
}
