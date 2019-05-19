import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);

                List<Integer> part1_res = diffWaysToCompute(part1);
                List<Integer> part2_res = diffWaysToCompute(part2);

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
