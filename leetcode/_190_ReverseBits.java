public class _190_ReverseBits {
    /**
     * Bit Manipulation
     * time: O(1)
     * space: O(1)
     */
    public int reverseBits(int n) {
        if (n == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // add the bit of res from left to right
            res <<= 1;
            // last bit of n is 1, add 1 to the last bit of res
            if ((n & 1) == 1)
                res++;
            // move the bit of n from right to left
            n >>= 1;
        }

        return res;
    }
}
