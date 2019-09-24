import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _1192_CriticalConnectionsinaNetwork {
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        int disc[] = new int[n];
        int low[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(parent, -1);

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                bridgeUtil(i, graph, visited, disc, low, parent, res);
            }
        }

        return res;
    }

    private void bridgeUtil(int u, List<Integer>[] graph, boolean visited[], int disc[], int low[], int parent[], List<List<Integer>> res) {
        visited[u] = true;

        disc[u] = low[u] = ++time;

        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u].get(i);
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, graph, visited, disc, low, parent, res);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(u);
                    ans.add(v);
                    res.add(ans);
                }
            } else if (v != parent[u]) {
                low[u]  = Math.min(low[u], disc[v]);
            }
        }
    }
}
