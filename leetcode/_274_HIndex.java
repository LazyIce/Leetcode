import java.util.Arrays;

public class _274_HIndex {
    /**
     * time: O(nlog)
     * space: O(1)
     */
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int res = 0;
        Arrays.sort(citations);
        while (res < citations.length && citations[citations.length - res - 1] > res) {
            res++;
        }

        return res;
    }

    /**
     * Bucket Sort
     * time: O(n)
     * space: O(n)
     */
    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        int[] buckets = new int[citations.length + 1];
        for(int c : citations) {
            if(c >= citations.length) {
                buckets[citations.length]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = citations.length; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
