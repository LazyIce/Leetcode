public class _275_HIndexII {
    /**
     * Binary Search
     * time: O(logn)
     * space: O(1)
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (citations[mid] == len - mid)
                return citations[mid];
            else if (citations[mid] > len - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return len - low;
    }
}
