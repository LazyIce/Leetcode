public class ContainerWithMostWater {
    /**
     * time: O(N)
     * space: O(1)
     */
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length <= 1)
            return res;
        int low = 0, high = height.length - 1;
        while (low < high) {
            res = Math.max(res, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return res;
    }
}
