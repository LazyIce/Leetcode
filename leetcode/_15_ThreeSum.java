import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _15_ThreeSum {
    /**
     * time: O(n^2)
     * space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // sort before two pointers
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // handle the first number duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // two pointers
            int low = i + 1, high = nums.length - 1;
            int sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // handle the second number duplicates
                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
