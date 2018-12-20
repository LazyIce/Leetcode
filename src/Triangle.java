/**
 * time: O(n^2)
 * space: O(n)
 */
import java.util.List;
import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty())
            return 0;
        int m = triangle.size();
        List<Integer> cur, pre = new ArrayList<>();
        pre.add(triangle.get(0).get(0));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cur.add(triangle.get(i).get(j) + pre.get(j));
                } else if (j < i) {
                    cur.add(Math.min(pre.get(j), pre.get(j - 1)) + triangle.get(i).get(j));
                } else {
                    cur.add(triangle.get(i).get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        for (Integer num : pre) {
            min = Math.min(min, num);
        }
        return min;
    }
}
