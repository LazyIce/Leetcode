/**
 * time: O(n^2)
 * space: O(1)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] < sum)
                    low++;
                else if (nums[low] + nums[high] > sum)
                    high--;
                else {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low+1])
                        low++;
                    while (low < high && nums[high] == nums[high-1])
                        high--;
                    low++;
                    high--;
                }
            }
        }
        return res;
    }
}
