public class _306_AdditiveNumber {
    /**
     * time: O(n^2)
     * space: O(1)
     */
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3)
            return false;
        // (0, i)  first number
        // (i, i + j) second number
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
                if (helper(i, j, num))
                    return true;
            }
        }

        return false;
    }

    public boolean helper(int i, int j, String num) {
        // handle the corner case 01...
        if (num.charAt(0) == '0' && i > 1)
            return false;
        if (num.charAt(i) == '0' && j > 1)
            return false;
        // check whether this is fibonacci
        String sum = "";
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 += x1;  // update x2 = sum
            x1 = x2 - x1;   // update x1 = old x2
            sum = x2.toString();
            if (!num.startsWith(sum, start))
                return false;
        }
        return true;
    }
}
