public class _231_PowerofTwo {
    /**
     * Iteration
     * time: O(logn)
     * space: O(1)
     */
    public boolean isPowerOfTwo1(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        return n == 1;
    }

    /**
     * Bit Manipulation
     * time: O(1)
     * space: O(1)
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}
