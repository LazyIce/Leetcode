import java.util.Queue;
import java.util.LinkedList;

public class _490_TheMaze {
    /**
     * BFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            visited[cur.x][cur.y] = true;
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int newX = cur.x;
                int newY = cur.y;
                while (isValid(maze, newX + direction[0], newY + direction[1])) {
                    newX += direction[0];
                    newY += direction[1];
                }
                if (!visited[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return false;
    }

    public boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
