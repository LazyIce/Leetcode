import java.util.List;
import java.util.ArrayList;

public class _118_PascalsTriangle {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0)
            return res;
        List<Integer> list = new ArrayList<>();

        // add 1 to first position, then update the numbers between first num and last num
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            res.add(new ArrayList<>(list));
        }

        return res;
    }
}
