import java.util.List;
import java.util.ArrayList;

public class _282_ExpressionAddOperators {
    /**
     * time: TBD
     * space: O(n)
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        helper(res, num, target, "", 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, String num, int target, String formula, int start, long val, long pre) {
        // our choices
        if (start == num.length()) {
            if (val == target) {
                res.add(formula);
                return;
            }
        }
        for (int i = start; i < num.length(); i++) {
            // our constraints
            if (i != start && num.charAt(start) == '0')
                break;
            long cur = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                helper(res, num, target, formula + cur, i + 1, cur, cur);
            } else {
                // our choices
                helper(res, num, target, formula + "+" + cur, i + 1, val + cur, cur);
                helper(res, num, target, formula + "-" + cur, i + 1, val - cur, -cur);
                helper(res, num, target, formula + "*" + cur, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }
}
