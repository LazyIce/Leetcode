import java.util.Stack;

public class _456_132Pattern {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int third = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            } else {
                while (!st.isEmpty() && nums[i] > st.peek()) {
                    third = st.pop();
                }
                st.push(nums[i]);
            }
        }

        return false;
    }
}
