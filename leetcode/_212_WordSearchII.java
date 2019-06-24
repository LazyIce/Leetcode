import java.util.List;
import java.util.ArrayList;

public class _212_WordSearchII {
    /**
     * Trie + Backtracking + DFS
     * time: O(m*n*TrieNode)
     * space: O(TrieNode)
     */
    class TrieNode {
        private TrieNode[] children;
        private String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null)
            return;
        TrieNode cur = root.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, cur, res);
        dfs(board, i + 1, j, cur, res);
        dfs(board, i, j - 1, cur, res);
        dfs(board, i, j + 1, cur, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode();
                }
                cur = cur.children[i];
            }
            cur.word = word;
        }

        return root;
    }
}
