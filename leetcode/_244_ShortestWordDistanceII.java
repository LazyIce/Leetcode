import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _244_ShortestWordDistanceII {
    private Map<String,List<Integer>> map;
    public _244_ShortestWordDistanceII(String[] words) {
        map = new HashMap();
        int i = 0;
        for(String word : words){
            List<Integer> list = map.getOrDefault(word, new ArrayList<>());
            list.add(i);
            map.put(word, list);
            i++;
        }
    }

    public int shortest(String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        for(int i : map.get(word2)){
            for(int j : map.get(word1)){
                int val = Math.abs(i - j);
                dist = Math.min(dist,val);
            }
        }
        return dist;
    }
}
