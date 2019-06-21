public class _201_BitwiseANDofNumbersRange {
    /**
     * Bit Manipulation
     * time: O(n-m)
     * space: O(1)
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m)
            n &= n-1;
        return n;
    }
}
