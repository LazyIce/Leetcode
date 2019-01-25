/**
 * time：O(n)
 * space: O(n)
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> window = new ArrayDeque<Integer>();//monotonic queue, store index
        int index = 0;
        for (int i = 0; i < n; i++) {
            //move out invalid number
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            //move index within window form right to left, which nums[index] < nums[i]
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[window.peek()];
            }
        }
        return res;
    }
}
