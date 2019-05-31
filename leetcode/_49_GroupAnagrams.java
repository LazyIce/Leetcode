import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class _49_GroupAnagrams {
    /**
     * time: O(n * m), n is length of String[] strs, m is max length of str in strs
     * space: O(n)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap<>();
        // 1. use an array int[26] to save word and transform it into ascending order of characters
        for (int i = 0; i < strs.length; i++) {
            int[] chars = new int[26];
            for (Character ch : strs[i].toCharArray()) {
                chars[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != 0) {
                    sb.append(chars[j]);
                    sb.append(j);
                }
            }
           // 2. use hashmap to track and save word
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(strs[i]);
            map.put(sb.toString(), list);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * time: O(n * mlogm)   n is length of String[] strs, m is length of str in strs
     * space: O(n)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
