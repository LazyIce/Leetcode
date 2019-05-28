import java.util.Stack;

public class _32_LongestValidParentheses {
    /**
     * Stack
     * time: O(n)
     * space: O(n)
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() < 2)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty())
                        res = Math.max(res, i - start);
                    else
                        res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }

    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(n)
     *
     i : [0,1,2,3,4,5]
     s : [( ,) ,( ,( ,) ,) ]
     dp:[0,2,0,0,2,6]
     */
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}
