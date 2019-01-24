public class FindPeakElement {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int findPeakElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i+1])
                    return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i-1])
                    return i;
            } else {
                if (nums[i] > nums[i-1] && nums[i] > nums[i+1])
                    return i;
            }
        }
        return -1;
    }

    /**
     * time: O(logn)
     * space: O(1)
     */
    public int findPeakElement2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
