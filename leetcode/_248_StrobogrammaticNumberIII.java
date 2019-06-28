import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _248_StrobogrammaticNumberIII {
    /**
     * DFS
     * time: TBD
     * space: O(n)
     */
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            list.addAll(helper(i, i));
        }
        for (String num : list) {
            if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
                continue;
            }
            res++;
        }
        return res;
    }

    private List<String> helper(int cur, int max) {
        if (cur == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (cur == 1)
            return new ArrayList<>(Arrays.asList("1", "8", "0"));

        List<String> res = new ArrayList<>();
        List<String> center = helper(cur - 2, max);

        for (int i = 0; i < center.size(); i++) {
            String temp = center.get(i);
            if (cur != max)
                res.add("0" + temp + "0");
            res.add("1" + temp + "1");
            res.add("8" + temp + "8");
            res.add("6" + temp + "9");
            res.add("9" + temp + "6");
        }
        return res;
    }
}
