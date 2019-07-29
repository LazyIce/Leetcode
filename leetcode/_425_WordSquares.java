import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class _425_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
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
}
