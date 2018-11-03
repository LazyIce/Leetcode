/**
 * time: O(n)
 * space:  O(n)
 */
import java.util.List;
import java.util.ArrayList;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
