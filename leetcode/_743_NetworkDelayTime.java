import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, K});
        visited[K] = true;
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];
            if (visited[curNode]) {
                continue;
            } else {
                visited[curNode] = true;
            }
            res = curDist;
            N--;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.offer(new int[] {curDist + map.get(curNode).get(next), next});
                }
            }
        }

        return N == 0 ? res : -1;
    }
}
