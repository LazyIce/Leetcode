public class _300_LongestIncreasingSubsequence {
    /**
     * Dynamic Programming
     * time: O(n^2)
     * space: O(n)
     */
    public int lengthOfLIS1(int[] nums) {
        int[] maxLens = new int[nums.length];
        int maxLen = 0;
        for(int i =0; i < nums.length; i++) {
            for(int j=0; j < i; j++)
                if(nums[i] > nums[j])
                    maxLens[i] = Math.max(maxLens[j]+1, maxLens[i]);
            maxLen = Math.max(maxLen, maxLens[i]+1);
        }
        return maxLen;
    }

    /**
     * Binary Search
     * time: O(nlogn)
     * space: O(n)
     */
    public int lengthOfLIS2(int[] nums) {
        int[] maxLens = new int[nums.length + 1];
        int maxLen = 0;
        for(int num : nums) {
            int len = binarySearch(num, maxLen, maxLens);
            maxLen = Math.max(len, maxLen);
            maxLens[len] = num;
        }
        return maxLen;
    }

    public int binarySearch(int num, int maxLen, int[] maxLens) {
        int left = 1, right = maxLen;
        while(left <= right) {
            int mid = (right-left) / 2 + left;
            if(maxLens[mid] < num)
                left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
