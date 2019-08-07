import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class _737_SentenceSimilarityII {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> p : pairs) {
            graph.putIfAbsent(p.get(0), new HashSet<>());
            graph.putIfAbsent(p.get(1), new HashSet<>());
            graph.get(p.get(0)).add(p.get(1));
            graph.get(p.get(1)).add(p.get(0));
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))
                continue;
            if (!graph.containsKey(words1[i]))
                return false;
            if (!dfs(graph, words1[i], words2[i], new HashSet<>()))
                return false;
        }

        return true;
    }

    public boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target))
            return true;

        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited))
                    return true;
            }
        }

        return false;
    }
}
