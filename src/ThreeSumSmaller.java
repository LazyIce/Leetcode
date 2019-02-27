import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i+1, high = nums.length - 1;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum < target) {
                    res += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
