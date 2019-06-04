import java.util.Stack;

public class _71_SimplifyPath {
    /**
     * time: O(n)
     * space: O(n)
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;

        String[] dirs = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();   // go back to last dir
            } else if (!dir.equals(".") && !dir.equals("")) {
                stack.push(dir);   // keep the next dir
            }
        }

        String res ="";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0)
            return "/";

        return res;
    }
}
