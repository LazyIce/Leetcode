public class _33_SearchinRotatedSortedArray {
    /**
     * Binary Search (find sorted part)
     * time: O(logn)
     * space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int res = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return mid;
            // [low-mid] is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // [mid-high] is sorted
            if (nums[mid] <= nums[high]) {
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return res;
    }
}
