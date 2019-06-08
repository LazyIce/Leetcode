import java.util.List;
import java.util.ArrayList;

public class _95_UniqueBinarySearchTreesII {
    /**
     * Dynamic Programming
     * Catalan Number!
     * time: O(n^2)
     * space: O(n)
     */
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<>();
        if (n == 0)
            return res[0];
        res[0].add(null);
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (TreeNode left : res[j]) {
                    for (TreeNode right : res[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
    }

    public TreeNode clone(TreeNode node, int n) {
        if (node == null)
            return node;
        TreeNode cur = new TreeNode(node.val + n);
        cur.left = clone(node.left, n);
        cur.right = clone(node.right, n);
        return cur;
    }

    /**
     * Recursion
     * time: O(n^2)
     * space: O(n)
     */
    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<>();
        return genTreeList(1, n);
    }

    public List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = genTreeList(start, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
