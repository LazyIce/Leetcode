import java.util.Arrays;

public class HorseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] list1 = Arrays.copyOfRange(nums,0,nums.length - 1);
        int[] list2 = Arrays.copyOfRange(nums,1,nums.length);
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(helper(list1,dp1,list1.length-1),helper(list2,dp2,list2.length-1));
    }

    public int helper(int[] nums, int[] dp, int start) {
        if(start < 0) return 0;
        if(dp[start] >= 0) return dp[start];
        dp[start] = Math.max(helper(nums,dp,start - 1),helper(nums,dp,start - 2) + nums[start]);
        return dp[start];
    }
}
