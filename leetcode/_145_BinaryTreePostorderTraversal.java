import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class _145_BinaryTreePostorderTraversal {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null)
            return;

        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
        return res;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public static List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            // push cur node and right node to the stack
            // set the left node and right node of cur node null to avoid dead loop
            while(cur != null){
                stack.push(cur);
                if(cur.right != null){
                    stack.push(cur.right);
                    cur.right = null;
                }
                TreeNode temp = cur.left;
                cur.left = null;
                cur = temp;
            }
            cur = stack.pop();
            // check cur has no left or right child
            if(cur.left == null && cur.right == null){
                res.add(cur.val);
                cur = null;
            }
        }
        return res;
    }
}
