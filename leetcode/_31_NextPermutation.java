public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        // find the first num which is in ascend order from the end
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }

        // origin nums descend
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // find the first num > first small num from the end
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        /**
         From: 1           2         5          4           3
                         firstSmall                        firstLarge
         to:     1            3        5          4           2
         to:     1           3         2          4           5
         */
        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
