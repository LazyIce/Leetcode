import java.util.Set;

public class ChessGame {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean check(char[][] board, int i, int j, Set<String> visited, char color) {
        String query = i + "->" + j;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited.contains(query))
            return false;

        if(board[i][j] == color) {
            visited.add(query);
            for(int[] dir : directions) {
                if(check(board, i+dir[0], j+dir[1], visited, color))
                    return true;
            }
            return false;
        } else if(board[i][j] == '.') {
            //把剩下连通的同色棋子标记为visited
            dfs(board, i, j, visited, color);
            return true;
        } else {
            return false;
        }
    }

    public void dfs(char[][] board, int i, int j, Set<String> visited, char color) {
        String query = i + "->" + j;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited.contains(query) || board[i][j] != color)
            return;
        visited.add(query);
        for(int[] dir : directions) {
            dfs(board, i+dir[0], j+dir[1], visited, color);
        }
    }
}
