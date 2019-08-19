public class _678_ValidParenthesisString {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public boolean checkValidString(String s) {
        int low = 0; // * as right parenthesis, count of left parenthesis
        int high = 0;  // * as left parenthesis. count of left parenthesis
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}
