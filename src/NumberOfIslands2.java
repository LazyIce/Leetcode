import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0)
            return res;
        int[] unionArr = new int[m*n];
        Arrays.fill(unionArr, -1);
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int cnt = 0;
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int id = row * n + col;
            if (unionArr[id] == -1) {
                unionArr[id] = id;
                cnt++;
            }
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                int cur_id = x * n + y;
                if (x < 0 || y < 0 || x >= m || y >= n || unionArr[cur_id] == -1) {
                    continue;
                }
                int p = find(unionArr, cur_id), q = find(unionArr, id);
                if (p != q) {
                    unionArr[p] = q;
                    cnt--;
                }
            }
            res.add(cnt);
        }
        return res;
    }

    int find(int[] unionArr, int id) {
        return (id == unionArr[id]) ? id : find(unionArr, unionArr[id]);
    }
}
