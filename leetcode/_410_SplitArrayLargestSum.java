public class _410_SplitArrayLargestSum {
    /**
     * Binary Search
     * time: O(logn)
     * space: O(1)
     *
     * Use binary search to approach the correct answer.
     * left = max number of array; right = sum of all numbers in the array; mid = (left + right) / 2;
     * Use greedy to narrow down left and right boundaries in binary search.
     * 3.1 Cut the array from left.
     * 3.2 Try the best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
     * 3.3 End up with two results: either we can divide the array into more than m subarrays or we cannot.
     * If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. We should increase m. This leads to l = mid + 1;
     * If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one. This leads to r = mid - 1;
     */
    public int splitArray(int[] nums, int m) {
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
