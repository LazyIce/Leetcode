import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _417_PacificAtlanticWaterFlow {
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    /**
     * DFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][]pacific = new boolean[m][n];
        boolean[][]atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int i = 0; i < n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
        return res;
    }

    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }

    /**
     * BFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        //Vertical border
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        //Horizontal border
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m - 1, i});
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited) {
        int m = matrix.length, n = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d : dir){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
