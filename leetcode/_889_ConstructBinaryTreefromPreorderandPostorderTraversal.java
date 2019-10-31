public class _889_ConstructBinaryTreefromPreorderandPostorderTraversal {
    /**
     * Recursion
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int preL, int preR, int[] post, int postL, int postR) {
        if (preL > preR || postL > postR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        if (preL == preR) {
            return root;
        }

        int index = -1;
        for (int i = postL ; i < postR ; i++) {
            if (pre[preL+1] == post[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return root;
        }

        root.left = constructFromPrePost(pre, preL + 1, preL + 1 + (index - postL), post, postL, index);
        root.right = constructFromPrePost(pre, preL + 1 + (index - postL) + 1, preR, post, index+1, postR);
        return root;
    }
}
