import java.util.Arrays;

public class _164_MaximumGap {
    /**
     * Bucket Sort
     * time: O(n)
     * space: O(n)
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // calculate the average gap
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        if (gap == 0)  // all the numbers are same
            return 0;
        // calculate the size of bucket
        int size = (int)((max - min) / gap) + 1;
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        // store the min and max for each bucket
        for (int num : nums) {
            if (num == min || num == max)
                continue;
            int bucket = (num - min) / gap;
            bucketMin[bucket] = Math.min(num, bucketMin[bucket]);
            bucketMax[bucket] = Math.max(num, bucketMax[bucket]);
        }
        // result should be the min in current bucket - max in previous bucket
        int res = 0;
        int prev = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE || bucketMax[i] == Integer.MIN_VALUE)
                continue;
            res = Math.max(res, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}
