import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _947_MostStonesRemovedwithSameRoworColumn {
    /**
     * DFS
     */
    public int removeStones1(int[][] stones) {
        Map<Integer, Set<Integer>> rSet = new HashMap<>(), cSet = new HashMap<>();
        for(int[] e : stones) {
            int r = e[0], c = e[1];
            rSet.putIfAbsent(r, new HashSet<>());
            cSet.putIfAbsent(c, new HashSet<>());
            rSet.get(r).add(c);
            cSet.get(c).add(r);
        }

        int count = 0;
        Set<String> v = new HashSet<>();
        for(int[] e : stones) {
            String key = e[0]+","+e[1];
            if(!v.contains(key)) {
                count++;
                v.add(key);
                dfs(e[0], e[1], rSet, cSet, v);
            }
        }
        return stones.length - count;
    }

    void dfs(int r, int c, Map<Integer, Set<Integer>> rSet, Map<Integer, Set<Integer>> cSet, Set<String> v) {
        for(int y : rSet.get(r)) {
            String key = r+","+y;
            if(!v.contains(key)) {
                v.add(key);
                dfs(r, y, rSet, cSet, v);
            }
        }

        for(int x : cSet.get(c)) {
            String key = x+","+c;
            if(!v.contains(key)) {
                v.add(key);
                dfs(x, c, rSet, cSet, v);
            }
        }
    }


    /**
     * Union Find
     */
    public int removeStones2(int[][] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] root = new int[stones.length];
        for(int i = 0; i < root.length; i++) root[i] = i;

        int idx = 0, union_count = 0;
        for(int[] e : stones) {
            int r = e[0], c = e[1] + 10000;
            Integer rgid = map.get(r), cgid = map.get(c);

            if(rgid != null && cgid != null) {
                int rid = findParent(root, rgid);
                int cid = findParent(root, cgid);
                if(rid != cid) {
                    union_count++;
                    root[rid] = cid;
                }
            } else if(rgid != null) {
                int rid = findParent(root, rgid);
                map.put(c, rid);
            } else if(cgid != null) {
                int cid = findParent(root, cgid);
                map.put(r, cid);
            } else {
                map.put(r, idx);
                map.put(c, idx);
                idx++;
            }
        }
        return stones.length- idx + union_count;
    }

    int findParent(int root[], int idx) {
        while(root[idx] != idx) {
            root[idx] = root[root[idx]];
            idx = root[idx];
        }
        return idx;
    }
}
