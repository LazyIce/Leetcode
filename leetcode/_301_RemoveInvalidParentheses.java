import java.util.List;
import java.util.ArrayList;

public class _301_RemoveInvalidParentheses {
    /**
     * DFS
     * time: O(n^2)
     * space: O(n)
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        for (int count = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0])
                count++;
            if (s.charAt(i) == pair[1])
                count--;
            if (count >= 0)
                continue;
            // illegal right parenthesis
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        // reverse string to handle illegal left parenthesis
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
}
