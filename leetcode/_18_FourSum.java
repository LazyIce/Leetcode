import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _18_FourSum {
    /**
     * time: O(n^3)
     * space: O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        // sort before two pointers
        Arrays.sort(nums);

        // four sum -> three sum -> two sum
        for (int i = 0; i < nums.length - 3; i++) {
            // handle duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // target for three sum
            int sum3 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                // handle duplicates
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                // target for two sum
                int sum2 = sum3 - nums[j];
                // two pointers
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        // handle duplicates
                        while (low + 1 < high && nums[low + 1] == nums[low])
                            low++;
                        while (high - 1 > low && nums[high - 1] == nums[high])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum2) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return res;
    }
}
