import java.util.Stack;

public class _388_LongestAbsoluteFilePath {
    /**
     * DFS
     * time: O(n)
     * space: O(n)
     */
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String str : input.split("\n")) {
            int level = str.lastIndexOf("\t") + 1;
            // for the same level, delete the former subdirectory
            while (level + 1 < stack.size())
                stack.pop();
            int len = stack.peek() + str.length() - level + 1; // +1 for "/"
            stack.push(len);
            if (str.contains("."))
                res = Math.max(res, len - 1);
        }

        return res;
    }
}
