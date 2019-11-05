public class Subtree {
    /**
     * Recursion
     * time: O(m*n)
     * space: O(m)
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /**
     * Iteration
     * time: O(m*n)
     * space: O(m)
     */
     public boolean isSubtree2(TreeNode s, TreeNode t) {
         String tree1 = preorder(s, true);
         String tree2 = preorder(t, true);
         return tree1.indexOf(tree2) >= 0;
     }

     public String preorder(TreeNode t, boolean left) {
         if (t == null) {
             if (left)
                 return "lnull";
             else
                 return "rnull";
         }

         return "#"+t.val + " " + preorder(t.left, true)+" " + preorder(t.right, false);
     }
}
