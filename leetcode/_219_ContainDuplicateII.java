import java.util.Set;
import java.util.HashSet;

public class _219_ContainDuplicateII {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
