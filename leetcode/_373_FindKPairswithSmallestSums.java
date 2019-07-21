import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class _373_FindKPairswithSmallestSums {
    /**
     * minHeap
     * time: O(klogk)
     * space: O(k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        // keep the all pairs of (nums1[i], nums2[0]), consider nums1[i] + nums[j] > nums[i+1] + nums[j - 1]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        // use minHeap to sort, we can get nums[i], nums[j] from the minHeap, then put nums[i], nums[j + 1] back
        while (!pq.isEmpty() && k-- > 0) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1)
                continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return res;
    }
}
