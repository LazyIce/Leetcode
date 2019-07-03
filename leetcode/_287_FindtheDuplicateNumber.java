public class _287_FindtheDuplicateNumber {
    /**
     * Binary Search
     * If there is no duplicate, the (#elements < n/2) = (#elements > n/2)
     * If (#elements < n/2) > n / 2, the duplicate number < n/2
     * If (#elements > n/2) > n / 2, the duplicate number > n/2
     * time: O(nlogn)
     * space: O(1)
     */
    public int findDuplicate1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Two Pointers
     * Like find duplicate in linked list
     * time: O(n)
     * space: O(1)
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
