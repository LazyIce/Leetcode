public class ProductOfArrayExceptSelf {
    /**
     * time: O(N)
     * space: O(N)
     *
     * [1, a1, a1*a2, a1*a2*a3]
     * [a2*a3*a4, a3*a4, a4, 1]
     */
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] seq1 = new int[len];
        int[] seq2 = new int[len];
        seq1[0] = 1;
        seq2[len-1] = 1;
        int prod = 1;
        for (int i = 1; i < len; i++) {
            seq1[i] = seq1[i-1] * nums[i-1];
        }
        for (int i = len - 2; i >= 0; i--) {
            seq2[i] = seq2[i+1] * nums[i+1];
        }
        for (int i = 0; i < len; i++) {
            seq1[i] = seq1[i] * seq2[i];
        }
        return seq1;
    }

    /**
     * time: O(N)
     * space: O(1)
     */
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int p = 1;
        res[0] = p;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * p;
            p = p * nums[i];
        }
        return res;
    }
}
