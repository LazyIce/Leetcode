import java.util.Queue;
import java.util.LinkedList;

public class _934_ShortestBridge {
    /**
     * time: O(m*n)
     * space: O(m*n)
     */
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        // dfs to find the island, mark it visited
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, queue, i, j, dirs);
                    found = true;
                    break;
                }
            }
        }
        // bfs to expand this island
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                        if (A[newX][newY] == 1) {
                            return step;
                        } else {
                            queue.offer(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public void dfs(int[][] A, boolean[][] visited, Queue<int[]> queue, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(A, visited, queue, i + dir[0], j + dir[1], dirs);
        }
    }
}
