public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    private Node helper(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] != 0, true, null, null, null, null);
        }
        Node res = new Node();
        Node topLeft = helper(grid, x, y, len / 2);
        Node topRight = helper(grid, x, y + len / 2, len / 2);
        Node bottomLeft = helper(grid, x + len / 2, y, len / 2);
        Node bottomRight = helper(grid, x + len / 2, y + len / 2, len / 2);
        if (topLeft.isLeaf && topRight.isLeaf
                && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            res.isLeaf = true;
            res.val = topLeft.val;
        } else {
            res.topLeft = topLeft;
            res.topRight = topRight;
            res.bottomLeft = bottomLeft;
            res.bottomRight = bottomRight;
        }
        return res;
    }
}
