public class _321_CreateMaximumNumber {
    /**
     * Greedy
     * time: O((m+n)^3)
     * space: O(k)
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        // get i numbers from num1 and get k - i numbers from nums2
        // if k <= n, min i = 0, else min i = k - n
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(temp, 0, res, 0)) {
                res = temp;
            }
        }

        return res;
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            // update the res if we find bigger number
            while (n - i > k - j && j > 0 && nums[i] > res[j - 1]) {
                j--;
            }
            // add the biggest number for current position j in res
            if (j < k) {
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }

    // merge the max array by order
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
