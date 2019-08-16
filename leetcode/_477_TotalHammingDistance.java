public class _477_TotalHammingDistance {
    /**
     * time: O(n)
     * space: O(1)
     * For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that bit set.
     * Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.
     */
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                count += (nums[j] >> i) & 1;
            }
            res += count * (len - count);
        }

        return res;
    }
}
