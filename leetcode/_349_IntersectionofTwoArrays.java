import java.util.Set;
import java.util.HashSet;

public class _349_IntersectionofTwoArrays {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Set<Integer> nums = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums1) {
            nums.add(num);
        }
        for (int num : nums2) {
            if (nums.contains(num)) {
                res.add(num);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            arr[i++] = num;
        }

        return arr;
    }
}
