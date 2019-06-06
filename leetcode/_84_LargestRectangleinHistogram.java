import java.util.Stack;

public class _84_LargestRectangleinHistogram {
    /**
     * Stack
     * time: O(n)
     * space: O(n)
     *
     stack : 1. push, increase，2. calculate, decrease
     e.g :
      0,1,2,3,4,5,6
     [2,1,5,6,2,3,0]

     stack : 1
     2 : push
     1 : height = 2 start = -1 res = 2
     5 : push
     6 : push
     2 : height = 6 start = 2 area = 6 res = 6
     height = 5 start = 1 area = 10 res = 10
     3 push
     0 : height = 2 start = 1 area = 8
     height = 1 start = -1 area = 6

     res = 10
     */
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i]; // handle the histograms increase all the way
            // once meet smaller height, calculate area
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);   // keep increasing height in stack
        }

        return res;
    }

    /**
     * Dynamic Programming
     * time: O(n)
     * space: (1)
     */
    public static int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
