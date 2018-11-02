public class SortColors {
    /**
     * time: O(n)
     * space: O(1)
     */
    public void sortColors1(int[] nums) {
        int red = 0;
        int white = 0;
        int blue  = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red)
                nums[i] = 0;
            if (i >= red && i < red + white)
                nums[i] = 1;
            if (i >= red+white && i < red+white+blue)
                nums[i] = 2;
        }
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index++, left++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
