public class _11_ContainerWithMostWater {
    /**
     * time complexity: O(n)
     * sapce complexity: O(1)
     *
     Two Pointers
     */
    public int maxArea(int[] height) {
        int res = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            res = Math.max(res, area);
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return res;
    }
}
