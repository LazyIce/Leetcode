import java.util.HashSet;
import java.util.Set;

public class _36_ValidSudoku {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> boxes = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                // check for rows
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                // check for columns
                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;
                // check for sub-boxes
                int boxRow = 3 * (i / 3);
                int boxCol = 3 * (i % 3);
                if (board[boxRow + j / 3][boxCol + j % 3] != '.' && !boxes.add(board[boxRow + j / 3][boxCol + j % 3]))
                    return false;
            }
        }

        return true;
    }
}
