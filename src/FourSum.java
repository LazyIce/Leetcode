/**
 * time: O(N^3)
 * space: O(1)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int sum1 = target - nums[i];
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int low = j+1, high = nums.length - 1, sum2 = sum1 - nums[j];
                while (low < high) {
                    if (nums[low] + nums[high] == sum2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum2)
                        low++;
                    else
                        high--;
                }
            }
        }
        return res;
    }
}
