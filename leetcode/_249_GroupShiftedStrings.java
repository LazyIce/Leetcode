import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _249_GroupShiftedStrings {
    /**
     * time: O(n*m), m is the max length of word in strings
     * space: O(n)
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList();
        if (strings == null || strings.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap();
        for(int i = 0; i < strings.length; i++){
            int offset = strings[i].charAt(0) - 'a';
            String key = "";
            for(int j = 0; j < strings[i].length(); j++){
                char c  =  (char)(strings[i].charAt(j) - offset);
                c = (c < 'a') ? (char)(c + 26) : c;
                key += c;
            }

            if(!map.containsKey(key)){
                List<String> temp = new ArrayList();
                map.put(key, temp);
            }
            map.get(key).add(strings[i]);
        }

        for(List<String> strList : map.values()){
            res.add(strList);
        }

        return res;
    }
}
