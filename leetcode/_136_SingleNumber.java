public class _136_SingleNumber {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
