import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _247_StrobogrammaticNumberII {
    /**
     * DFS
     * time: TBD
     * space: O(n)
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    // each recursion, get the n - 2 length string
    public List<String> helper(int cur, int max) {
        if (cur == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (cur == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(cur - 2, max);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if (cur != max) {
                res.add("0" + temp + "0");
            }
            res.add("1" + temp + "1");
            res.add("6" + temp + "9");
            res.add("8" + temp + "8");
            res.add("9" + temp + "6");
        }
        return res;
    }
}
