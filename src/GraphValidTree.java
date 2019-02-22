import java.util.*;

public class GraphValidTree {
    public boolean validTree1(int n, int[][] edges) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
        for (int[] edge : edges) {
            if (union(union, edge[0], edge[1]))
                return false;
        }
        for (int i = 0; i < n; i++) {
            union[i] = find(union, i).rootIndex;
        }
        for (int i = 0; i < n - 1; i++) {
            if (union[i+1] != union[i])
                return false;
        }
        return true;
    }

    public Root find(int[] union, int p) {
        int depth = 0;
        while (p != union[p]) {
            p = union[p];
            depth++;
        }
        return new Root(p, depth);
    }

    public boolean union(int[] union, int p, int q) {
        Root rp = find(union, p);
        Root rq = find(union, q);
        if (rp.depth < rq.depth) {
            union[rp.rootIndex] = rq.rootIndex;
        } else {
            union[rq.rootIndex] = rp.rootIndex;
        }
        if (rp.rootIndex == rq.rootIndex)
            return true;
        else
            return false;
    }

    class Root {
        int rootIndex;
        int depth;
        public Root(int rootIndex, int depth) {
            this.rootIndex = rootIndex;
            this.depth = depth;
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        if (n == 0)
            return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = helper(graph, visited, 0, -1);
        if (res == false)
            return false;
        if (visited.size() != n)
            return false;
        return true;
    }

    public boolean helper(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int parent) {
        List<Integer> sub = graph.get(node);
        for (int v : sub) {
            if (v == parent)
                continue;
            if (visited.contains(v))
                return false;
            visited.add(v);
            boolean res = helper(graph, visited, v, node);
            if (res == false)
                return false;
        }
        return true;
    }
}
