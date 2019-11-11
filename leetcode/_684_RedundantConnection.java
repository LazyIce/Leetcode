import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class _684_RedundantConnection {
    public int[] findRedundantConnection1(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < edges.length + 1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];

            Set<Integer> visited = new HashSet<>();

            if(dfs(visited, u, v, adjList)){ // return true if there's a path between u and v already
                // connect u and v directly make it a graph from tree
                return edge;
            }
            // if the path doesnt exist

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return null;
    }
    private boolean dfs(Set<Integer> visited, int u, int v, List<List<Integer>> adjList){
        // base case , when u and v are the same pos
        if(u == v) return true;

        // else, mark u as visited
        visited.add(u);


        // check every nei, dfs on nei
        for(int nei : adjList.get(u)){
            if(visited.contains(nei)) continue;
            if(dfs(visited, nei, v, adjList)) return true;
        }
        return false;
    }

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(uf.find(u) == uf.find(v)){
                return edge;
            }else{
                uf.union(u, v);
            }
        }
        return null;
    }

    class UnionFind{
        int[] parent;

        public UnionFind(int n){
            parent = new int[n + 1];
            for(int i = 1; i < n + 1; i++){
                parent[i] = i;
            }
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            parent[pa] = pb;
        }

        public int find(int x){
            while(parent[x] != x){
                x = parent[x];
            }
            return x;
        }
    }
}
