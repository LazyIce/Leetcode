/**
 * time: O(n^2)
 * space: O(n)
 */
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> init_row = new ArrayList<>();
        init_row.add(1);
        res.add(init_row);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            List<Integer> last_row = res.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    row.add(last_row.get(j - 1) + last_row.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
