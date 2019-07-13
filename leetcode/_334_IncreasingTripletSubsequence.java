public class _334_IncreasingTripletSubsequence {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min)
                min = num;
            else if (num < secondMin)
                secondMin = num;
            else if (num > secondMin)
                return true;
        }
        return false;
    }
}
