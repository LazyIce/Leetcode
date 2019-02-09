import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public int findUnsortedSubarray1(int[] nums) {
        int[] nums_sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums_sorted);

        int i = 0, j = nums.length - 1;

        while (i < nums.length && nums[i] == nums_sorted[i])
            i++;
        while (i < j && nums[j] == nums_sorted[j])
            j--;

        return j - i + 1;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int findUnsortedSubarray2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r && nums[l] <= nums[l + 1]) l++;

        if (l >= r) return 0;

        while (nums[r] >= nums[r - 1]) r--;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int k = l; k <= r; k++) {
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
        }

        while (l >= 0 && min < nums[l]) l--;
        while (r < nums.length && nums[r] < max) r++;

        return (r - l - 1);
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int findUnsortedSubarray3(int[] nums) {
        int i = 0, j = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
            max = Math.max(max, nums[l]);
            if (nums[l] != max) j = l;

            min = Math.min(min, nums[r]);
            if (nums[r] != min) i = r;
        }

        return (j - i + 1);
    }
}
