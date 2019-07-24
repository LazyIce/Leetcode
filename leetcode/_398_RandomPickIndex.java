import java.util.Random;

public class _398_RandomPickIndex {
    class Solution {
        private int[] nums;
        private Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int res = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target)
                    continue;
                if (rand.nextInt(++count) == 0) {
                    res = i;
                }
            }

            return res;
        }
    }
}
