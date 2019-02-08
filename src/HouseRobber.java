/**
 * time: O(n)
 * space: O(n)
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memos = new int[nums.length + 1];
        memos[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            memos[i] = Math.max(memos[i - 2] + nums[i-1], memos[i - 1]);
        }
        return memos[nums.length];
    }
}
