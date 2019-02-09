/**
 * time: O(m)
 * space: O(n)
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s == null || s.length() < p.length())
            return res;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();

        int begin = 0, end = 0;

        int len = p.length();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == len) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebaba";
        String p = "abc";

        List<Integer> res = findAnagrams(s, p);
        System.out.print(res);
    }
}
