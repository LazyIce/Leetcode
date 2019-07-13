public class _334_IncreasingTripletSubsequence {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, sedMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < sedMin) sedMin = num;
            else if (num > sedMin) return true;
        }
        return false;
    }
}
