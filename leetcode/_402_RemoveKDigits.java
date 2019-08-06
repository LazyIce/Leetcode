import java.util.Stack;

public class _402_RemoveKDigits {
    /**
     * time: O(n)
     * space: O(n)
     */
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        // corner case: 1111
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int res = 0;
        while (res < sb.length() && sb.charAt(res) == '0') {
            res++;
        }
        return res == sb.length() ? "0" : sb.substring(res);
    }
}
