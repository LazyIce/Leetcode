public class _172_FactorialTrailingZeroes {
    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
