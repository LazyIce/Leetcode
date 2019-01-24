public class MedianOfTwoSortedArray {
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
}
