public class _26_RemoveDuplicatesfromSortedArray {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // Two pointers
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1])
                continue;
            else
                nums[i++] = nums[j];
        }
        return i;
    }
}
