import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedString {
    public List<List<String>> groupStrings(String[] strings) {
        int len = strings.length;
        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> res = new ArrayList();

        for(int i = 0; i < len; ++i){
            int offset = strings[i].charAt(0) - 'a';
            String key = "";
            for(int j = 0; j <  strings[i].length(); j++){
                char c  =  (char)(strings[i].charAt(j) - offset);
                c = (c < 'a')? (char)(c + 26) : c;
                key += c;
            }

            if(!map.containsKey(key)){
                List<String> temp = new ArrayList();
                map.put(key, temp);
            }
            map.get(key).add(strings[i]);
        }

        for(List<String> listStr : map.values()){
            res.add(listStr);
        }

        return res;
    }
}
