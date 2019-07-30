public class _410_SplitArrayLargestSum {
    /**
     * Binary Search
     * time: O(nlogn)
     * space: O(1)
     */
    public int splitArray(int[] nums, int m) {
        // left = max number of array; right = sum of all numbers in the array;
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) {
            return (int)sum;
        }
        long left = max;
        long right = sum;
        // Use greedy to narrow down left and right boundaries in binary search.
        while (left <= right) {
            long mid = (left + right) / 2;
            if (valid(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)left;
    }

    public boolean valid(long target, int[] nums, int m) {
        // If we can divide the array into more than m parts and the sum of each part is less than mid, it means that the mid value we pick is too small.
        // So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid.
        // We should increase m. This leads to left = mid + 1;
        // If we can either divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m.
        // Both of them mean that we should lower mid because we need to find the minimum one. This leads to right = mid - 1;
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
