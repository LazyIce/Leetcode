public class _75_SortColors {
    /**
     * Bucket Sort
     * time: O(n)
     * space: O(n)
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int[] buckets = new int[3];
        for (int num : nums) {
            buckets[num]++;
        }
        int val = 0, count = 0;
        for (int bucket : buckets) {
            for (int i = 0; i < bucket; i++) {
                nums[count + i] = val;
            }
            count+= bucket;
            val++;
        }
    }

    /**
     * One-Pass
     * time: O(n)
     * space: O(1)
     */
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int low = 0, high = nums.length - 1; // low: track 0, high: track 2
        int index = 0;
        while (index <= high) {
            if (nums[index] == 0)
                swap(nums, index++, low++);
            else if (nums[index] == 1)
                index++;
            else
                swap(nums, index, high--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
