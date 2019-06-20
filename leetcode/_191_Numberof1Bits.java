public class _191_Numberof1Bits {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                res++;
            n >>= 1;
        }

        return res;
    }
}
