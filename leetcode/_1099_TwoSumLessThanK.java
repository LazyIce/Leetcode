import java.util.Arrays;

public class _1099_TwoSumLessThanK {
    /**
     * time: O(nlogn)
     * space: O(1)
     */
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length < 2) {
            return -1;
        }
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int res = -1;
        while (i < j) {
            if (A[i] + A[j] < K) {
                res = Math.max(A[i] + A[j], res);
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
