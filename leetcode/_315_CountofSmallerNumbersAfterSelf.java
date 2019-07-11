import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _315_CountofSmallerNumbersAfterSelf {
    /**
     * Binary Indexed Tree
     * time: O(nlogn)
     * space: O(n)
     */
    private int[] BIT;

    public List<Integer> countSmaller(int[] nums) {
        // nums: [5, 2, 6, 1]
        // copy: [1, 2, 5, 6]
        // rank: [3, 2, 4, 1]
        // BIT:  [0,
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(copy, nums[i]) + 1;
        }
        BIT = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            res.add(getSum(nums[i] - 1));
            update(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int getSum(int idx) {
        int sum = 0;
        for (int i = idx; i >= 1; i -= i & (-i)) {
            sum += BIT[i];
        }
        return sum;
    }

    private void update(int idx) {
        for (int i = idx; i < BIT.length; i += i & (-i)) {
            BIT[i]++;
        }
    }
}
