import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class _336_PalindromePairs {
    /**
     * time: O(n*k^2)
     * space: O(n)
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2reverse = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2reverse) && map.get(str2reverse) != i) {
                        res.add(Arrays.asList(map.get(str2reverse), i));
                    }
                }
                if (str2.length() != 0 && isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        res.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
