import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode>[] res = new List[n + 1];
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

    public TreeNode clone(TreeNode root, int n) {
        if (root == null) {
            return root;
        }
        TreeNode cur = new TreeNode(root.val + n);
        cur.left = clone(root.left, n);
        cur.right = clone(root.right, n);
        return cur;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0)
            return new ArrayList<>();
        return genTreeList(1, n);
    }

    public List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        }
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> leftlist = genTreeList(start, idx - 1);
            List<TreeNode> rightlist = genTreeList(idx + 1, end);
            for (TreeNode left : leftlist) {
                for (TreeNode right : rightlist) {
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
