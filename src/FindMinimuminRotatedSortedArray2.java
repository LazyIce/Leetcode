/**
 * time: O(logn)
 * space: O(1)
 */
public class FindMinimuminRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == nums[end]) {
                end--;//nums[end] can be removed because it must not be the minimum element
            } else if (nums[mid] > nums[end]) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (nums[begin] <= nums[end]) {
            return nums[begin];
        }
        return nums[end];
    }
}
