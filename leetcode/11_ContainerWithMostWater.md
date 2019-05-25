# Container With Most Water

## Description

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

## Solution

We can use Two Pointers.

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(1)
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
```





