import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class _261_GraphValidTree {
    /**
     * graph -> tree: undirected connected graph without cycle
     * DFS
     * time: O(edge*edge)
     * space: O(n)
     */
    public boolean validTree1(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = helper(graph, visited, 0, -1);
        if (res == false)
            return false;
        return visited.size() == n ? true : false;
    }

    public boolean helper(List<List<Integer>> graph, Set<Integer> visited, int node, int parent) {
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

    /**
     * BFS
     * time: O(edge*edge)
     * space: O(n)
     */
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited.contains(node))
                return false;
            for (int v : graph.get(node)) {
                queue.offer(v);
                graph.get(v).remove(new Integer(node));
            }
            visited.add(node);
        }

        return visited.size() == n;
    }

    /**
     * Union find
     * time: O(edge*edge)
     * space: O(n)
     */
    public boolean validTree3(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)
            return true;
        if (n < 1 || edges == null || edges.length != n - 1)
            return false;

        int[] roots = new int[n];
        Arrays.fill(roots, -1);

        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            if (x == y)
                return false;
            roots[x] = y;
        }

        return true;
    }

    public int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
