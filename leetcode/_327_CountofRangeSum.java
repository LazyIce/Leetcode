import java.util.Map;
import java.util.TreeMap;

public class _327_CountofRangeSum {
    /**
     * TreeMap
     * time: O(n^2)
     * space: O(n)
     * find lower <= sum[i] - sum[j] <= upper
     * i.e: in 0 <= j < i, sum[i] - upper <= sum[j] <= sum[i] - lower
     */
    public int countRangeSum1(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0)
            return 0;
        // key is the sum, value is the count of sum
        TreeMap<Long, Long> map = new TreeMap<>();
        map.put((long)0, (long)1);
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = map.subMap(from, true, to, true);
            for (Long value : sub.values()) {
                count += value;
            }
            map.put(sum, map.getOrDefault(sum, (long)0) + 1);
        }
        return (int)count;
    }

    /**
     * Merge sort
     * time: O(nlogn)
     * space: O(n)
     */
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        return helper(sum, new long[sum.length], 0, sum.length - 1, lower, upper);
    }

    public int helper(long[] sum, long[] helper, int low, int high, long lower, long upper) {
        if (low >= high) {
            return 0;
        }

        int mid = (high + 1 - low) / 2 + low;
        int count = helper(sum, helper, low, mid - 1, lower, upper)
                + helper(sum, helper, mid, high, lower, upper);

        int rangeStart = mid, rangeEnd = mid;
        for(int i = low; i < mid; i++) {
            while(rangeStart <= high && sum[rangeStart] - sum[i] < lower)
                rangeStart++;
            while(rangeEnd <= high && sum[rangeEnd] - sum[i] <= upper)
                rangeEnd++;

            count += rangeEnd - rangeStart;
        }

        merge(sum, helper, low, mid, high);
        return count;
    }

    public void merge(long[] sum, long[] helper, int low, int mid, int high) {
        int left = low, right = mid, idx = low;

        while(left < mid && right <= high) {
            if (sum[left] <= sum[right])
                helper[idx++] = sum[left++];
            else
                helper[idx++] = sum[right++];
        }

        while(left < mid)
            helper[idx++] = sum[left++];
        while(right <= high)
            helper[idx++] = sum[right++];

        System.arraycopy(helper, low, sum, low, high + 1 - low);
    }
}
