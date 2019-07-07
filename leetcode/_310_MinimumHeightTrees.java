import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class _310_MinimumHeightTrees {
    /**
     * build graph,
     * then find leaf and remove them among their neighbors, level by level.
     * Until left less 2 nodes
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        // build graph
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // get the nodes whose degree is one
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
                res.add(i);
        }
        // when n == 2, return res
        // when n > 2
        while (n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res) {
                for (int j : adj.get(i)) {
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        leaves.add(j);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
}
