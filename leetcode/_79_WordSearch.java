public class _79_WordSearch {
    /**
     * DFS
     * time: TBD
     * space: TBD
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, int i, int j, String word, int index) {
        // all the characters in word is counted
        if (index >= word.length())
            return true;
        // out of bound
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        // do DFS
        if (board[i][j] == word.charAt(index)) {
            index++;
            char c = board[i][j];
            board[i][j] = '*';   // mark as visited state
            boolean res = exist(board, i - 1, j, word, index) ||
                    exist(board, i + 1, j, word, index) ||
                    exist(board, i, j - 1, word, index) ||
                    exist(board, i, j + 1, word, index);
            board[i][j] = c;   // revert to unvisited state
            return res;
        }

        return false;
    }
}
