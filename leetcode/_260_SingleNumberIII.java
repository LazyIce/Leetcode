public class _260_SingleNumberIII {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2)
            return new int[]{-1, -1};
        // get the XOR result of two target numbers
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // find the target numbers from XOR result
        int[] res = new int[2];
        diff &= -diff; // get the index of diff bit
        // change the problem into single number
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
