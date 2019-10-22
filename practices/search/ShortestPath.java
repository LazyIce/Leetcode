import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{0,0,0}, {1,1,0}, {1,1,0}};
        List<int[]> path = shortestPathBinaryMatrix(grid);
        for (int[] item : path) {
            System.out.println(Arrays.toString(item));
        }
    }

    static int[][] dir = new int[][] {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public static List<int[]> shortestPathBinaryMatrix(int[][] grid) {
        List<int[]> res = new ArrayList<>();
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) {
                    int curPos = cur[0] * grid[0].length + cur[1];
                    while (map.containsKey(curPos)) {
                        int parent = map.get(curPos);
                        int row = parent / grid[0].length;
                        int col = parent % grid[0].length;
                        res.add(0, new int[] {row, col});
                        curPos = parent;
                    }
                    return res;
                }

                for (int j = 0; j < 8; j++) {
                    int newX = cur[0] + dir[j][0];
                    int newY = cur[1] + dir[j][1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        map.put(newX * grid[0].length + newY, cur[0] * grid.length + cur[1]);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return res;
    }
}
