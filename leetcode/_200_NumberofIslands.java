import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberofIslands {
    /**
     * DFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * BFS
     * time: O(m*n)
     * space: O(m*n)
     */
    public int numIslands2(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; i++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        Queue<Integer> queue = new LinkedList<>();
        int code = x * grid.length + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / grid.length;
            int j = code % grid.length;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * grid.length + j);
                grid[i - 1][j] = '0';
            }
            if (i < grid[0].length - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * grid.length + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer((i * grid.length) + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < grid.length - 1 && grid[i][j + 1] == '1') {
                queue.offer((i * grid.length) + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    /**
     * Union Find
     * time: O(m*n)
     * space: O(m*n)
     */
    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowNum = grid.length;
        int columnNum = grid[0].length;

        int[] unionInfoArray = new int[rowNum * columnNum];
        initUnion(unionInfoArray);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int unionIndex = columnNum * i + j;
                if (grid[i][j] == '1') {
                    if (i+1 < rowNum && grid[i+1][j] == '1') {
                        union(unionInfoArray, unionIndex, columnNum * (i + 1) + j);
                    }
                    if (j+1 < columnNum && grid[i][j+1] == '1') {
                        union(unionInfoArray, unionIndex, columnNum * i + j + 1);
                    }
                } else {
                    unionInfoArray[unionIndex] = -1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < unionInfoArray.length; i++) {
            if (unionInfoArray[i] != -1 && unionInfoArray[i] == i) {
                result ++;
            }
        }
        return result;
    }

    private void initUnion(int[] unionInfoArray) {
        if (unionInfoArray == null) return;
        for (int i = 0; i < unionInfoArray.length; i++) {
            unionInfoArray[i] = i;
        }
    }

    private Root root(int[] union, int i) {
        int depth = 0;
        while (i != union[i]) {
            depth ++;
            i = union[i];
        }
        return new Root(depth, i);
    }

    private void union(int[] union, int p, int q) {
        Root i = root(union, p);
        Root j = root(union, q);
        if (i.depth < j.depth) {
            union[i.rootIndex] = j.rootIndex;
        } else {
            union[j.rootIndex] = i.rootIndex;
        }
    }

    class Root {
        int depth;
        int rootIndex;
        public Root(int depth, int rootIndex) {
            this.depth = depth;
            this.rootIndex = rootIndex;
        }
    }
}
