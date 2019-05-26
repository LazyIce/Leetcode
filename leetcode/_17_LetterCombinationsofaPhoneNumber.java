import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {
    // index is number of digits
    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
     * time: O(3^n)
     * space: O(n)
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;

        helper(res, digits, "", 0);

        return res;
    }

    // Backtracking: compute all, generate all
    public void helper(List<String> res, String digits, String sb, int index){
        // Our goal
        if (index == digits.length()) {
            res.add(sb);
            return;
        }
        // our choice
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // no constraints
            helper(res, digits, sb + letters.charAt(i), index+1);
        }
    }
}
