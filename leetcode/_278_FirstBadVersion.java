public class _278_FirstBadVersion {
    /**
     * Binary Search
     * time: log(n)
     * space: O(1)
     */
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (isBadVersion(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public boolean isBadVersion(int num) {
        return true;
    }
}
