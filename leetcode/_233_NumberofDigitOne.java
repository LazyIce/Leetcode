public class _233_NumberofDigitOne {
    /**
     * time: O(logn)
     * space: O(1)
     *
     * number of 1 for hundred place:   0, 1, >=2 :
     * case 1: n=3141092, a= 31410, b=92. hundred place is 1: 3141 *100 次.
     * case 2: n=3141192, a= 31411, b=92. hundred place is 1: 3141 *100 + (92+1) 次.
     * case 3: n=3141592, a= 31415, b=92. hundred place is 1: (3141+1) *100 次.
     */
    public int countDigitOne(int n) {
        int res = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            // sum up the count of ones on every place k
            res += (a + 8) / 10 * m;
            if (a % 10 == 1)
                res += b + 1;
        }
        return res;
    }
}
