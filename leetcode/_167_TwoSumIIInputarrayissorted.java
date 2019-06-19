public class _167_TwoSumIIInputarrayissorted {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{low + 1, high + 1};
            else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return res;
    }
}
