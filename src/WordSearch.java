/**
 * time: N/A
 * space: N/A
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        for(int r = 0; r < board.length && !found; ++r) {
            for(int c = 0; c < board[r].length && !found; c++)
                found = dfs(board, word, 0, r, c);
        }
        return found;
    }

    private boolean dfs(char[][] board, String word, int index, int r, int c) {
        if(index >= word.length())
            return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '-')
            return false;
        if(word.charAt(index) != board[r][c])
            return false;

        char ch = board[r][c];
        board[r][c] = '-'; //mark visited
        boolean match = dfs(board,word, index + 1, r + 1, c) || dfs(board,word, index + 1, r - 1, c)
                ||dfs(board,word, index + 1, r , c + 1) || dfs(board,word, index + 1, r , c - 1);
        board[r][c] = ch; //backtrack
        return match;
    }
}
