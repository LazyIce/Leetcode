import java.util.List;
import java.util.ArrayList;

public class _241_DifferentWaystoAddParentheses {
    /**
     * Divide and Conquer, Recursion
     * time: O(n^3)
     * space: O(n)
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // once encounter the operator, we calculate the results for both sides
            if (ch == '+' || ch == '-' || ch == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);

                List<Integer> part1_res = diffWaysToCompute(part1);
                List<Integer> part2_res = diffWaysToCompute(part2);
                // add the results in both sides
                for (Integer res1 : part1_res) {
                    for (Integer res2 : part2_res) {
                        if (ch == '+')
                            res.add(res1 + res2);
                        else if (ch == '-')
                            res.add(res1 - res2);
                        else
                            res.add(res1 * res2);
                    }
                }
            }
        }

        if (res.size() == 0)
            res.add(Integer.valueOf(input));

        return res;
    }
}
