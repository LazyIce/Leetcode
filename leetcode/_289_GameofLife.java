public class _289_GameofLife {
    /**
     * time: O(m*n)
     * space: O(1)
     *
     * [2nd bit, 1st bit] = [next state, current state]
     *
     * - 00  dead (next) <- dead (current)
     * - 01  dead (next) <- live (current)
     * - 10  live (next) <- dead (current)
     * - 11  live (next) <- live (current)
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);
                // Initially, every 2nd bit is 0
                // we need to find out when will the 2nd bit become 1.
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;  // Make the 2nd bit 1: 01 ---> 11
                    }
                } else if (count == 3) {
                    board[i][j] += 2;  // Make the 2nd bit 1: 01 ---> 11
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;  // Get the 2nd state.
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j)
                    continue;
                if ((board[row][col] & 1) == 1)
                    count++;
            }
        }
        return count;
    }
}
