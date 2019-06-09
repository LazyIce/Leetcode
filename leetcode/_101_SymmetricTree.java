import java.util.Stack;

public class _101_SymmetricTree {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSame(p.left, q.right) && isSame(p.right, q.left);

        return false;
    }

    /**
     * Iterative
     * time: O(n)
     * space: O(n)
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null)
                return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }
}
