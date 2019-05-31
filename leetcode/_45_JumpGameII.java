public class _45_JumpGameII {
    /**
     * Greedy Algorithm
     * time: O(n)
     * space: O(1)
     */
    public int jump1(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int res = 0, curEnd = 0, curFarest = 0;
        for (int i = 0; i < nums.length - 1; i++) {   // * < nums.length - 1
            // track the max position for next step
            curFarest = Math.max(curFarest, nums[i] + i);
            // need one step to the new curEnd = curFarest
            if (i == curEnd) {
                res++;
                curEnd = curFarest;
            }
        }

        return res;
    }

    /**
     * BFS
     * time: O(n)
     * space: O(1)
     *
     [2, 3, 1, 1, 4]
     2 -> 3, 1 -> 1, 4
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int res = 0, curEnd = 0, curFarest = 0, level = 0, i = 0;
        while (curEnd - i + 1 > 0) {
            level++;
            for(; i <= curEnd; i++) {
                // traverse current level, update the max reach of next level
                curFarest = Math.max(curFarest, i + nums[i]);
                if (curFarest >= nums.length - 1)
                    return level;
            }
            curEnd = curFarest;
        }

        return res;
    }
}
