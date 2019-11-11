import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class _815_BusRoute {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Set<Integer> used = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new LinkedList<>());
                graph.get(routes[i][j]).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (int bus : graph.get(queue.poll())) {
                    if (used.add(bus)) {
                        for (int j = 0; j < routes[bus].length; j++) {
                            if (routes[bus][j] == T) {
                                return res;
                            } else {
                                queue.offer(routes[bus][j]);
                            }
                        }
                    }
                }
            }
            res++;
        }

        return -1;
    }
}
