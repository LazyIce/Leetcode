import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class _257_BinaryTreePaths {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root, "");
        return res;
    }
    public static void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;

        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();

        sNode.push(root);
        sStr.push("");

        while(!sNode.isEmpty()) {
            TreeNode curNode=sNode.pop();
            String curStr=sStr.pop();

            if(curNode.left == null && curNode.right == null)
                res.add(curStr + curNode.val);

            if(curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }

            if(curNode.right!=null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }

        return res;
    }
}
