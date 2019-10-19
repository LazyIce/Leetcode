import java.util.List;
import java.util.ArrayList;

public class _679_24Game {
    /**
     * time: O(n^3)
     * space: O(n)
     */
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }
        return dfs(list);
    }

    public boolean dfs(List nums) {
        if (nums.size() == 1) {
            double diff = (double)nums.get(0) - 24.0;
            return Math.abs(diff) < 0.001;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> list = compute((double)nums.get(i), (double)nums.get(j));
                for (double num : list) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(num);
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nextRound.add((double)nums.get(k));
                        }
                    }
                    if (dfs(nextRound) == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public List<Double> compute(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add(a + b);
        list.add(a - b);
        list.add(b - a);
        list.add(a * b);
        list.add(a / b);
        list.add(b / a);
        return list;
    }
}
