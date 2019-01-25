/**
 * time: O(n)
 * space: O(1)
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null)
            return;
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
