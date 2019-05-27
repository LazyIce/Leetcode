import java.util.List;
import java.util.ArrayList;

public class _22_GenerateParentheses {
    /**
     * BackTracking
     * time: O(n! * 2^n)
     * spcae: O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n <= 0)
            return res;

        helper(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    public void helper(List<String> res, StringBuilder sb, int open, int close, int max) {
        // Our goal: sb.length() == n * 2
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }
        // Our choice: place '(' or ')'
        // our constraint:
        // 1. #'(' and #')' aren't more than max
        // 2. '()' is closed
        if (open < max) {
            sb.append('(');
            helper(res, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            helper(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
