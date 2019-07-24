public class _400_NthDigit {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        // calculate the number contains the nth digit
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);

        return s.charAt((n - 1) % len) - '0';
    }
}
