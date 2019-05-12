import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {
    HashMap<String, List<Integer>> hmap;

    public ShortestWordDistance2(String[] words) {
        hmap = new HashMap();
        int i = 0;
        for(String s:words){
            List<Integer> list = new ArrayList();
            if(hmap.containsKey(s)){
                list = hmap.get(s);
            }
            list.add(i);
            hmap.put(s,list);
            i++;
        }
    }

    public int shortest(String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        for(int i : hmap.get(word2)){
            for(int j : hmap.get(word1)){
                int val = Math.abs(i-j);
                dist = Math.min(dist,val);
            }
        }
        return dist;
    }
}
