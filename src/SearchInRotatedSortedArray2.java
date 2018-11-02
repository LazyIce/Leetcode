/**
 * time: O(n) || O(logn)
 * space: O(1)
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[high] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid;
                else
                    low = mid;
            } else if (nums[mid] <= nums[high]) {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid;
                else
                    high = mid;
            }
        }
        if (nums[low] == target)
            return true;
        if (nums[high] == target)
            return true;
        return false;
    }
}
