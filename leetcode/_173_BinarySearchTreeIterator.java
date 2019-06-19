import java.util.Stack;

public class _173_BinarySearchTreeIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || cur != null)
            return true;
        else
            return false;
    }
}
