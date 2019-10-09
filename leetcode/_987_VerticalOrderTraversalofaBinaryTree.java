import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class _987_VerticalOrderTraversalofaBinaryTree {
    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if (o1.x < o2.x) {
                    return -1;
                }
                if (o1.x > o2.x) {
                    return 1;
                }
                if (o1.y < o2.y) {
                    return 1;
                }
                if (o1.y > o2.y) {
                    return -1;
                }
                return o1.val - o2.val;
            }
        });

        verticalTraverseTree(pq, root, 0, 0);
        List<Integer> list = new ArrayList<>();
        Point prev = null;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(prev == null || p.x != prev.x){
                if (prev != null) {
                    res.add(list);
                }
                list = new ArrayList<>();
            }
            list.add(p.val);
            prev = p;
        }

        if(res.size() > 0) {
            res.add(list);
        }

        return res;
    }

    public void verticalTraverseTree(PriorityQueue<Point> pq, TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        pq.add(new Point(node.val, x, y));
        verticalTraverseTree(pq, node.left, x - 1, y - 1);
        verticalTraverseTree(pq, node.right, x + 1, y - 1);
    }

    class Point {
        int val;
        int x;
        int y;

        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
