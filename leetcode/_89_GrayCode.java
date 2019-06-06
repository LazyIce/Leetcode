import java.util.List;
import java.util.ArrayList;

public class _89_GrayCode {
    /**
     * time: O(n)
     * space: O(1)
     */
    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i < n; i++) {
            int size = res.size();
            // each time, you add 1 in the first bit
            for(int j = size - 1; j >= 0; j--)
                res.add(res.get(j) | 1 << i);
        }

        return res;
    }

    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1 << n ; i++)
            res.add(i ^ i >> 1);

        return res;
    }
}
