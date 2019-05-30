public class _42_TrappingRainWater {
    /**
     * Sliding Window, Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;

        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        // always update the lower side
        // water comes from the:
        // 1. leftMax - height[left]
        // 2. rightMax - height[right]
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
