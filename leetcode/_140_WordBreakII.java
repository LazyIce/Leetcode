import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _140_WordBreakII {
    /**
     * DFS
     * time: O(n^3)
     * space: O(n^3)
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        // <start index, break words list
        Map<Integer, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, 0, map);
    }

    public List<String> dfs(String s, List<String> wordDict, int start, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> res = new ArrayList<>();
        // end of answer, no space
        if (start == s.length()) {
            res.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                // dfs to get answer
                List<String> list = dfs(s, wordDict, end, map);
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
