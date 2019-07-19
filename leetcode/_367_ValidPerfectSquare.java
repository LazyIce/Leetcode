public class _367_ValidPerfectSquare {
    /**
     * time: O(sqrt(n))
     * space: O(1)
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 0)
            return false;
        if (num == 1)
            return true;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num)
                return true;
        }
        return false;
    }

    /**
     * time: O(logn)
     * space: O(1)
     */
    public boolean isPerfectSquare2(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /**
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * ...
     * time: O(n)
     * space: O(1)
     */
    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
