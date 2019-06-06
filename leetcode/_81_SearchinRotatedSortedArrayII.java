public class _81_SearchinRotatedSortedArrayII {
    /**
     * Binary Search
     * time: O(logn) worst O(n)
     * space: O(1)
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            // handle duplicates
            while (low < high && nums[low] == nums[high])
                low++;
            // binary search
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return true;
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else if (nums[mid] <= nums[high]) {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
