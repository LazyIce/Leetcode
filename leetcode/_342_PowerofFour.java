public class _342_PowerofFour {
    /**
     * time: O(1)
     * space: O(1)
     */
    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
