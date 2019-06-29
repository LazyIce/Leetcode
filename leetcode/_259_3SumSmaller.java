import java.util.Arrays;

public class _259_3SumSmaller {
    /**
     * Two Pointers
     * time: O(n^2)
     * space: O(1)
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] < sum) {
                    res += (high - low);
                    low++;
                }
                else {
                    high--;
                }
            }
        }

        return res;
    }
}
