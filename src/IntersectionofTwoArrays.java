import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class IntersectionofTwoArrays {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> intersect = new HashSet();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            res[index++] = num;
        }
        return res;
    }

    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        // forwarding pointers 前向型指针
        //用two pointers的方法可以解决nums1太小或者nums2太小的case
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }
}
