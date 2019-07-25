public class _481_HammingDistance {
    /**
     * Bit Manipulation
     * time: O(logn)
     * space: O(1)
     */
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;
        while (xor != 0) {
            xor &= (xor - 1);
            res++;
        }

        return res;
    }
}
