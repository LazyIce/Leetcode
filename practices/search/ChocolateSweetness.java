public class ChocolateSweetness {
    public static void main(String[] args) {
        int[] nums = new int[] {6, 3, 2, 8, 7, 5};
        int k = 3;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, m, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }


    private static boolean canSplit(int[] nums, int m, int minSum) {
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= minSum) {
                sum = 0;
                count++;
            }
        }
        return count >= m;
    }
}
