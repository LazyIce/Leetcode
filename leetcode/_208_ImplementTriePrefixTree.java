class TrieNode {
    public boolean is_word;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        is_word = false;
    }
}

public class _208_ImplementTriePrefixTree {
    /**
     * Trie
     */
    private TrieNode root;

    // Initialize the data structure here
    public _208_ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    // insert a word into the trie
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (p.children[index] == null)
                p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.is_word = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.is_word;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (p.children[index] == null)
                return null;
            p = p.children[index];
        }

        return p;
    }
}
