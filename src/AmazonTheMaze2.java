import java.util.Queue;
import java.util.LinkedList;

public class AmazonTheMaze2 {
    class Point {
        public int x, y, l;

        public Point(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start[0], start[1], 0));

        int[] dirs = {-1, 0, 1, 0, -1};

        while (!que.isEmpty()) {
            Point cur = que.poll();
            if (cur.l >= res[cur.x][cur.y]) {
                continue;
            }
            res[cur.x][cur.y] = cur.l;

            for (int k = 0; k < 4; ++k) {
                int x = cur.x, y = cur.y, l = cur.l;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dirs[k];
                    y += dirs[k + 1];
                    l++;
                }
                x -= dirs[k];
                y -= dirs[k + 1];
                l--;

                que.offer(new Point(x, y, l));
            }
        }

        return res[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : res[destination[0]][destination[1]];
    }
}
