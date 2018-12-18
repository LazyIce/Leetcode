/**
 * time: O(n)
 * space: O(1)
 */
public class PopulatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null && cur.right != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) {
                    if (cur.next.left != null)
                        cur.right.next = cur.next.left;
                    else if (cur.next.right != null)
                        cur.right.next = cur.next.right;
                }
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }
}
