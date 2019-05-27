public class _27_RemoveElement {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        // Two pointers
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val)
                continue;
            else
                nums[i++] = nums[j];
        }

        return i;
    }
}
