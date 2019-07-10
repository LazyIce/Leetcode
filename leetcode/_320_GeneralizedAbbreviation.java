import java.util.List;
import java.util.ArrayList;

public class _320_GeneralizedAbbreviation {
    /**
     * Backtracking
     * time: O(2^n)
     * space: O(n)
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null)
            return res;
        helper(res, word, "", 0, 0);
        return res;
    }

    public void helper(List<String> res, String word, String abbr, int count, int pos) {
        // our goals
        if (pos == word.length()) {
            if (count > 0)
                abbr += count;
            res.add(abbr);
        } else {
            // our choices
            helper(res, word, abbr, count + 1, pos + 1);
            helper(res, word, abbr + (count > 0 ? count : "") + word.charAt(pos), 0, pos + 1);
        }
    }
}
