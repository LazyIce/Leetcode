# Median of Two Sorted Arrays

## Description

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

## Solution

### Binary Search

If we want to find the median of two sorted arrays nums1 with length m and nums2 with length n, we just need to find the numbers of ```(m+n+1)/2``` position and ```(m+n+2)/2``` poistion in nums1 + nums2. So the problem is find k-th element in these two sorted arrays.

To find the k-th element, since both arrays are sorted, we can keep mid1 and mid2 as k/2-th elements in each array. If mid1 < mid2, which means the k-th element must be in the second half of nums1 or nums2. If mid2 < mid1, the k-th element must be in the second half of nums2 or nums1. We can do the binary search recursively to get the answer.

```java
/**
 * time complexity: O(log(min(M, N)))
 * sapce complexity: O(1)
 */
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int l = (m + n + 1) >> 1;
    int r = (m + n + 2) >> 1;
    return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
}

public double getKth(int[] A, int aStart, int[] B, int bStart, int k) {
    if (aStart >= A.length)
        return B[bStart + k - 1];
    if (bStart >= B.length)
        return A[aStart + k - 1];
    if (k == 1) {
        return Math.min(A[aStart], B[bStart]);
    }
    int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    if (aStart + k / 2 - 1 < A.length)
        aMid = A[aStart + k / 2 - 1];
    if (bStart + k / 2 - 1 < B.length)
        bMid = B[bStart + k / 2 - 1];
    if (aMid < bMid)
        return getKth(A, aStart + k / 2, B, bStart, k - k / 2);
    else {
        return getKth(A, aStart, B, bStart + k / 2, k - k / 2);
    }
}
```





