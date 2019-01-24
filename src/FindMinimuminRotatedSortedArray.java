/**
 * time: O(logn)
 * space: O(1)
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        //make sure it is rotated array,not[1,2,3]
        while (begin + 1 < end && nums[begin] > nums[end]) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < nums[begin]) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        //[2,1]
        if (nums[begin] > nums[end]) {
            return nums[end];
        }
        return nums[begin];
    }
}
