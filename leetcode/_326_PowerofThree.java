public class _326_PowerofThree {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }
}
