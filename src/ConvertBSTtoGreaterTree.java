/**
 * time: O(n)
 * space: O(n)
 *             8
 *           /   \
 *         5     13
 *        /  \    /  \
 *      2   7  9   15
 */
public class ConvertBSTtoGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
