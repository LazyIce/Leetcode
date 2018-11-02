/**
 * time: O(n)
 * space: O(n)
 */
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (stack.size() > 0) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0)
            return "/";
        return res;
    }
}
