public class _268_MissingNumber {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int missingNumber1(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     * a ^ b ^ b = a
     * traversal all the index and value, the xor result is the missing value
     */
    public int missingNumber2(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i; // this i refers to the last index
    }
}
