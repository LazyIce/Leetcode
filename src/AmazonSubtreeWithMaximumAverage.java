public class AmazonSubtreeWithMaximumAverage {
    class ResultType {
        TreeNode node;
        int sum;
        int size;
        public ResultType(TreeNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    private ResultType result = null;

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType rootResult = helper(root);
        return result.node;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, 0);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);

        ResultType currResult = new ResultType(root, leftResult.sum + rightResult.sum + root.val, leftResult.size + rightResult.size + 1);

        if (result == null || currResult.sum * result.size > result.sum * currResult.size) {
            result = currResult;
        }

        return currResult;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(-2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode res = new AmazonSubtreeWithMaximumAverage().findSubtree2(root);
        System.out.print(res.val);
    }
}
