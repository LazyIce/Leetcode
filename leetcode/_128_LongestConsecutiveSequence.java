import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class _128_LongestConsecutiveSequence {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            // check for smaller consecutive number
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            // check for larger consecutive number
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            res = Math.max(res, up - down - 1);
        }

        return res;
    }

    /**
     * Union Find
     * time: O(n)
     * space: O(n)
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int res = 1;
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int num : nums){
            if(!map.containsKey(num)) map.put(num,count++);
        }
        UnionFind uf = new UnionFind(count);
        for(int num : nums){
            if(map.containsKey(num - 1)) uf.union(map.get(num),map.get(num - 1));
            if(map.containsKey(num + 1)) uf.union(map.get(num),map.get(num + 1));
            res = Math.max(res,uf.rank[uf.find(map.get(num))]);
        }
        return res;
    }

    private class UnionFind{
        int[] id;
        int[] rank;
        private UnionFind(int n){
            id = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                id[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int i){
            if(i != id[i]){
                id[i] = find(id[i]);
            }
            return id[i];
        }
        public void union(int i,int j){
            int ii = find(i);
            int jj = find(j);
            if(ii == jj) return;
            if(rank[ii] > rank[jj]){
                id[jj] = ii;
                rank[ii] += rank[jj];
            }
            else{
                id[ii] = jj;
                rank[jj] += rank[ii];
            }
        }
    }

}
