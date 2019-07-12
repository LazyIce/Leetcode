import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _323_NumberofConnectedComponentsinanUndirectedGraph {
    /**
     * BFS
     * time: O(V+E)
     * space: O(n^2)
     */
    public int countComponents1(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];

        List<List<Integer>> adjacents = new ArrayList();
        for(int i = 0;i < n; i++){
            adjacents.add(new ArrayList());
        }
        for(int[] edge : edges){
            adjacents.get(edge[0]).add(edge[1]);
            adjacents.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                queue.offer(i);
                res++;
                while(!queue.isEmpty()){
                    int curNode = queue.poll();
                    visited[curNode] = true;
                    List<Integer> temp = adjacents.get(curNode);
                    for(int node: temp){
                        if(!visited[node])
                            queue.offer(node);
                    }
                }
            }
        }

        return res;
    }

    /**
     * Union Find
     * time: O(VE)
     * space: O(n)
     */
    public int countComponents2(int n, int[][] edges) {
        int res = n;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }
        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);
            if (x != y) {
                roots[x] = y;
                res--;
            }
        }

        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
