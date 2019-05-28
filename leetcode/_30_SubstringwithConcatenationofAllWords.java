import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _30_SubstringwithConcatenationofAllWords {
    /**
     * n is s.length(), m is words.length
     * time: O(n*m)
     * space: O(m)
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> allWords = new HashMap<>();
        int wordNum = words.length;
        int wordLen = words[0].length();

        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordNum * wordLen; i++) {
            Map<String, Integer> copy = new HashMap<>(allWords);
            int num = wordNum;
            int j = i;

            while (num > 0) {
                String word = s.substring(j, j + wordLen);
                // if word doesn't exist or #word isn't correct
                if (!copy.containsKey(word) || copy.get(word) < 1)
                    break;
                // if word exists, check next word, update the map, num, index
                copy.put(word, copy.get(word) - 1);
                num--;
                j += wordLen;
            }

            // match all words, add the index to res
            if (num == 0)
                res.add(i);
        }

        return res;
    }
}
