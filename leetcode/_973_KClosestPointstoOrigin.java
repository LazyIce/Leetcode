import java.util.PriorityQueue;
import java.util.Arrays;

public class _973_KClosestPointstoOrigin {
    /**
     * maxHeap
     * time: O(nlogk)
     * space: O(k)
     */
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] - b[1] * b[1] - a[0]*a[0] - a[1] * a[1]));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K)
                pq.poll();
        }
        int[][] res = new int[K][2];

        while (--K >= 0) {
            res[K] = pq.poll();
        }

        return res;
    }

    /**
     * QuickSelect
     * time: O(n)
     * space: O(n)
     */
    public int[][] kClosest2(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K)
                break;
            if (mid < K)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0)
                r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0)
                l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
