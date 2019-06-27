import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {
    /**
     * time: O(kn)
     * space: O(1)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int start = 0, end = k - 1;
        while (end < nums.length) {
            int max = nums[start];
            for (int i = start + 1; i <= end; i++) {
                max = Math.max(max, nums[i]);
            }
            res[start] = max;
            end++;
            start++;
        }

        return res;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }

        return res;
    }
}
