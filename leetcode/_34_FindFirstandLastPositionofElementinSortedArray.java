public class _34_FindFirstandLastPositionofElementinSortedArray {
    /**
     * Binary Search: (Search for first and last separately)
     * time: O(logn)
     * space: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = findFirst(nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }

        int end = findLast(nums, target);

        return new int[]{start, end};
    }

    public int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target)
            return low;
        if (nums[high] == target)
            return high;

        return -1;
    }

    public int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[high] == target)
            return high;
        if (nums[low] == target)
            return low;

        return -1;
    }
}
