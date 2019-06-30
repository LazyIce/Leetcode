public class _262_UglyNumber {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;

        while (num % 2 == 0)
            num /= 2;

        while (num % 3 == 0)
            num /= 3;

        while (num % 5 == 0)
            num /= 5;

        return num == 1;
    }
}
