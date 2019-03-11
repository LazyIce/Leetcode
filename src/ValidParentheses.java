import java.util.ArrayDeque;
import java.util.Deque;

/**
 * time: O(n)
 * space: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty())
                    return false;
                char left = stack.pop();
                if (left == '(' && ch != ')' || left == '[' && ch != ']' || left == '{' && ch != '}')
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
