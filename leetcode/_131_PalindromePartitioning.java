import java.util.List;
import java.util.ArrayList;

public class _131_PalindromePartitioning {
    /**
     * Backtracking
     * time: O(2^n)
     * space: O(n)
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();
        helper(res, s, new ArrayList<>());
        return res;
    }

    public void helper(List<List<String>> res, String s, List<String> list) {
        // our goal
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            // our choice
            String temp = s.substring(0, i + 1);
            // our constraint
            if (isPalindrome(temp)) {
                list.add(temp);
                helper(res, s.substring(i + 1), list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
}
