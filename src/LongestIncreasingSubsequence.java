import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                }
            }
        }
        int len = 0;
        for (int i = 0; i<=nums.length; i++) {
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0)
                i = -(i + 1);
            dp[i] = x;
            if(i == len)
                len++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3};
        int res = lengthOfLIS2(arr);
    }
}
