/**
 * time: O(k)
 * space: O(1)
 */

import java.util.List;
import java.util.ArrayList;
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        for (int i = 0; i < rowIndex - 1; i++) {
            double next = 1.0 * res.get(i) * (rowIndex - i) / (i + 1);
            res.add((int) next);
        }
        res.add(1);
        return res;
    }
}
