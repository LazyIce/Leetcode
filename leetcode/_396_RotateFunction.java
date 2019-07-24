public class _396_RotateFunction {
    /**
     * time: O(n)
     * space: O(1)
     * F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
     *               = (Bk[0] + ... + Bk[n-1]) - nBk[0]
     *               = sum - nBk[0]
     */
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        int res = candidate;
        for (int i = A.length - 1; i > 0; i--) {
            candidate = candidate + sum - A[i] * A.length;
            res = Math.max(res, candidate);
        }

        return res;
    }
}
