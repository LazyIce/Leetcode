import java.util.Stack;
import java.util.Arrays;

public class _951_FlipEquivalantBinaryTrees {
    /**
     * Iteration
     */
    public boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
        stk1.push(root1);
        stk2.push(root2);
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            TreeNode n1 = stk1.pop(), n2 = stk2.pop();
            if (n1 == null && n2 == null) {
                continue;
            } else if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }

            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) {
                stk1.addAll(Arrays.asList(n1.left, n1.right));
            }else {
                stk1.addAll(Arrays.asList(n1.right, n1.left));
            }
            stk2.addAll(Arrays.asList(n2.left, n2.right));
        }

        return stk1.isEmpty() && stk2.isEmpty();
    }

    /**
     * Recursion
     */
    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        if ((root1.left != null ? root1.left.val : -1) != (root2.left != null ? root2.left.val : -1)) {
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }

        return flipEquiv2(root1.left, root2.left) && flipEquiv2(root1.right, root2.right);
    }
}
