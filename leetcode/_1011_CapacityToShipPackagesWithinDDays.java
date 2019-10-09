public class _1011_CapacityToShipPackagesWithinDDays {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int need = 1;
            int cur = 0;
            int mid = (right - left) / 2 + left;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
