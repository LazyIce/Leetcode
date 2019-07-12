import java.util.Arrays;

public class _324_WiggleSortII {
    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public void wiggleSort1(int[] nums) {
        if(nums.length <= 1)
            return;
        int[] val = Arrays.copyOf(nums, nums.length);
        Arrays.sort(val);
        int idx = val.length - 1;
        for(int i = 1; i < nums.length; i += 2)
            nums[i] = val[idx--];
        for(int i = 0; i < nums.length; i += 2)
            nums[i] = val[idx--];
    }

    /**
     * QuickSelect + Partition
     * time: O(n)
     * space: O(1)
     */
    public void wiggleSort2(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, right = n - 1;
        int index = 0;
        while (index <= right) {
            if (nums[newIndex(index, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(index++, n));
            } else if (nums[newIndex(index, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(index, n));
            } else {
                index++;
            }
        }
    }

    public int newIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }
        swap(nums, left, r);
        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
