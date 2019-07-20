import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _368_LargestDivisibleSubset {
    /**
     * Dynamic Programming
     * time: O(nlogn)
     * space: O(n^2)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        int[] count = new int[nums.length]; // count[i]: the length of subset from [0, i], just like longest increasing subsequence
        int[] pre = new int[nums.length]; // keep the number in subset
        int max = 0, index = -1;

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            // if the num[i] can divide the biggest number in a set, add num[i] to this set
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
