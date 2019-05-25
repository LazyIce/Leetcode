public class _7_ReverseInteger {
    /**
     * time complexity: O(logx)
     * sapce complexity: O(1)
     *
     * Note: In Java, for a mod b, the result is (sign of a)*|a|%|b|
     */
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            // handle the bound of Integer
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return (int)res;
    }
}
