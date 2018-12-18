/**
 * time: O(n)
 * space: O(n)
 */
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        LinkedList<TreeLinkNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size != 0) {
                TreeLinkNode cur = list.poll();
                if (size == 1)
                    cur.next = null;
                else
                    cur.next = list.peek();
                if (cur.left != null)
                    list.offer(cur.left);
                if (cur.right != null)
                    list.offer(cur.right);
                size--;
            }
        }
    }
}
