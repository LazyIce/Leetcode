public class _338_CountingBits {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
