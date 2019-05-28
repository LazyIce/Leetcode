public class _35_SearchInsertPosition {
    /**
     * Binary Search
     * time: O(logn)
     * space: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (target <= nums[low])
            return low;
        else
            return low + 1;
    }
}
