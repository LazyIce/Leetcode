public class _370_RangeAddition {
    /**
     * Dynamic Programming
     * time: O(n+k)
     * space: O(n)
     *
     * [1 , 3 , 2] , [2, 3, 3] (length = 5)
     *
     * res[0, 2, 0, 0, -2]
     *
     * res[0 ,2, 3, 0, -5]
     *
     * sum[0, 2, 5, 5, 0]
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end + 1 < length) {
                res[end + 1] -= value;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
