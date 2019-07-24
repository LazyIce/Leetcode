import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class _399_EvaluateDivision {
    /**
     * DFS
     * time: O(V+E)
     * space: O(n)
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<Double>> val = new HashMap<>();
        double[] res = new double[queries.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = -1.0;
        }

        buildGraph(equations, values, graph, val);

        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                res[i] = -1.0;
            } else {
                dfs(res, x, y, graph, val, new HashSet<String>(), 1.0, i);
            }
        }

        return res;
    }

    public void dfs(double[] res, String x, String y, Map<String, List<String>> graph, Map<String, List<Double>> val, Set<String> visited, double temp, int index){
        if (x.equals(y)) {
            res[index] = temp;
            return;
        }

        for (int i = 0; i < graph.get(x).size(); i++) {
            String str = graph.get(x).get(i);
            if (visited.add(str)) {
                dfs(res, str, y, graph, val, visited, temp * val.get(x).get(i), index);
            }
        }
    }

    public void buildGraph(List<List<String>> equations, double[] values, Map<String, List<String>> graph, Map<String, List<Double>> val){
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
                val.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
                val.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);
            val.get(x).add(values[i]);
            val.get(y).add(1.0 / values[i]);
        }
    }
}
