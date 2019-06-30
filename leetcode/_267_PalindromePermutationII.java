import java.util.List;
import java.util.ArrayList;

public class _267_PalindromePermutationII {
    /**
     * Backtracking
     * time: TBD
     * space: O(1)
     */
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[256];
        int odds = 0;
        for (char c : s.toCharArray())
            count[c]++;
        for (int c : count)
            if (c % 2 != 0)
                odds++;
        if (odds <= 1) {
            Character center = null;
            for (int i = 0; i < count.length; i ++)
                if (count [i] % 2 == 1) {
                    center = ((char)i);
                    count[i] --;
                    break;
                }

            helper(res, count, (center != null ? String.valueOf(center) : new String ()), s.length());
        }
        return res;
    }

    public void helper(List<String> res, int[] count, String str, int len) {
        // our goal
        if (str.length() == len)
            res.add (new String(str));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) { // our constraints
                count[i] -= 2;
                helper(res, count, ((char)i) + str + ((char)i), len);  // our choices
                count[i] += 2;
            }
        }
    }
}
