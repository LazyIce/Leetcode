public class _360_SortTransformedArray {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        // a >= 0, maxValue is at start or end points, a < 0, maxValue is between start and end points
        int i = a >= 0 ? nums.length - 1 : 0;
        while (start <= end) {
            int startValue = getValue(nums[start], a, b, c);
            int endValue = getValue(nums[end], a, b, c);
            if (a >= 0) {
                if (startValue >= endValue) {
                    res[i--] = startValue;
                    start++;
                } else {
                    res[i--] = endValue;
                    end--;
                }
            } else {
                if (startValue <= endValue) {
                    res[i++] = startValue;
                    start++;
                } else {
                    res[i++] = endValue;
                    end--;
                }
            }
        }

        return res;
    }

    public int getValue(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
