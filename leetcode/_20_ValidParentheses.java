import java.util.Stack;

public class _20_ValidParentheses {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        boolean res = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else {
                // case: '())' and case '(]'
                if (stack.isEmpty() || stack.pop() != s.charAt(i))
                    return false;
            }
        }
        // case: '(()'
        return stack.isEmpty();
    }
}
