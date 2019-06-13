public class _137_SingleNumberII {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public int singleNumber(int[] nums) {
        // num appears for first time, store it in b
        // num appears for second time, store it in a
        // num appears for third time, clear a and b
        int a = 0, b = 0;
        for (int num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }

        return b;
    }
}
