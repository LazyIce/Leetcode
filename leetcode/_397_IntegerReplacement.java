public class _397_IntegerReplacement {
    /**
     * time: O(logn)
     * space: O(1)
     *
     * If n is even, halve it.
     * If n=3 or n-1 has less 1's than n+1, decrement n.
     * Otherwise, increment n.
     */
    public int integerReplacement(int n) {
        long N = n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N + 1 : N - 1;
            }
            res++;
        }

        return res;
    }
}
