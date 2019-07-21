public class _376_WiggleSubsequence {
    public int wiggleMaxLength1(int[] nums) {
        /**
         * Dynamic Programming
         * time: O(n)
         * space: O(n)
         */
        if (nums.length == 0)
            return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[ i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(1)
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0)
            return 0;

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
