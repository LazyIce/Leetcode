public class _374_GuessNumberHigherorLower {
    /**
     * Binary Search
     * time: O(logn)
     * space: O(1)
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start;
    }

    public int guess(int num) {
        return 0;
    }
}
