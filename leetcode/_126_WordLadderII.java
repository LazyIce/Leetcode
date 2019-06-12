import java.util.*;

public class _126_WordLadderII {
    /**
     * DFS
     * time: O(n)
     * space: O(n)
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, Map<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    /**
     * Bydirectional BFS
     * time: O(n)
     * space: O(n)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        bfs(map, set1, set2, dict, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(res, path, map, beginWord, endWord);
        return res;
    }

    private void bfs(Map<String, List<String>> map, Set<String> set1, Set<String> set2, Set<String> dict, boolean flip){
        if(set1.isEmpty()){
            return;
        }

        if(set1.size() > set2.size()){
            bfs(map, set2, set1, dict, !flip);
            return;
        }

        boolean done = false;
        dict.removeAll(set1);
        dict.removeAll(set2);

        HashSet<String> next = new HashSet<>();
        for(String str : set1){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char temp = chs[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(chs[i] != ch){
                        chs[i] = ch;
                        String word = new String(chs);

                        String key = flip ? word : str;
                        String val = flip ? str : word;

                        List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);

                        if(set2.contains(word)){
                            done = true;

                            list.add(val);
                            map.put(key, list);
                        }

                        if(!done && dict.contains(word)){
                            next.add(word);

                            list.add(val);
                            map.put(key, list);
                        }
                    }
                }
                chs[i] = temp;
            }
        }

        if(!done){
            bfs(map, set2, next, dict, !flip);
        }
    }

    private void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> map, String start, String end){
        if(start.equals(end)){
            res.add(new ArrayList<>(path));
            return;
        }

        if(!map.containsKey(start)){
            return;
        }

        for(String next : map.get(start)){
            path.add(next);
            dfs(res, path, map, next, end);
            path.remove(path.size() - 1);
        }
    }
}
