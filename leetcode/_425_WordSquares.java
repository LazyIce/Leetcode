import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class _425_WordSquares {
    /**
     * DFS
     * time: O(n!)
     * space: O(n*max(len(word)))
     */
    public List<List<String>> wordSquares1(String[] words) {
        // key is the prefix, value is the set of words with the same prefix
        Map<String, Set<String>> prefix = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String s = word.substring(0, i);
                prefix.putIfAbsent(s, new HashSet<>());
                prefix.get(s).add(word);
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> candidate;
        for (String word : words) {
            candidate = new ArrayList<>();
            candidate.add(word);
            dfs(res, candidate, 1, words[0].length(), prefix);
        }

        return res;
    }

    public void dfs(List<List<String>> res, List<String> candidate, int pos, int len, Map<String, Set<String>> prefix) {
        if (pos == len) {
            res.add(new ArrayList<>(candidate));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String cand : candidate) {
            sb.append(cand.charAt(pos));
        }
        if (!prefix.containsKey(sb.toString())) {
            return;
        }
        for (String next : prefix.get(sb.toString())) {
            candidate.add(next);
            dfs(res, candidate, pos + 1, len, prefix);
            candidate.remove(candidate.size() - 1);
        }
    }

    /**
     * Trie
     * time: O(n!)
     * space: O(n*max(len(word)))
     */
    class Node{
        String word = null;
        Node[] kids = new Node[26];
    }

    private Node root = new Node();

    public List<List<String>> wordSquares2(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.length == 0 || words[0] == null || words[0].length() == 0)
            return res;
        for(String word: words){
            buildTrie(word, root);
        }
        Node[] prefix = new Node[words[0].length()];
        Arrays.fill(prefix, root);
        findAllSquares(0, 0, prefix, res);
        return res;
    }

    private void buildTrie(String word, Node par){
        for(char c: word.toCharArray()){
            int idx = c -'a';
            if(par.kids[idx] == null) par.kids[idx] = new Node();
            par = par.kids[idx];
        }
        par.word = word;
    }

    public void findAllSquares(int row , int col, Node[] prefix, List<List<String>> res){
        if(row == prefix.length){
            List<String> temp = new ArrayList<String>();
            for(int i=0; i<prefix.length; i++){
                temp.add(prefix[i].word);
            }
            res.add(temp);
        } else if(col < prefix.length){
            Node currow = prefix[row];
            Node curcol = prefix[col];
            for(int i=0; i<26; i++){
                if(currow.kids[i] != null && curcol.kids[i] != null){   // from left to right in the same row
                    prefix[row] =  currow.kids[i];   //  prefix[row] increase to the word
                    prefix[col] =  curcol.kids[i];   //  upadte prefix[col]
                    findAllSquares(row, col+1, prefix, res);
                }
            }
            prefix[row] = currow;   // reset back
            prefix[col] = curcol;
        } else {
            findAllSquares(row+1, row+1, prefix, res);
        }
    }
}
