public class _43_MultiplyStrings {
    /**
     * time: O(m*n)
     * space: O(m+n)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        // e.g: 999 * 999 < 10^6
        int[] digits = new int[num1.length() + num2.length()];
        /**
                         2   3
         *              5   6
         ----------------------
                   1   3   8
              1   1   5
         -----------------------
             1   2    8   8
         */
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = prod + digits[i + j + 1];
                digits[i + j + 1] = sum % 10;
                digits[i + j] += sum / 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (!(digits[i] == 0 && res.length() == 0))
                res.append(digits[i]);
        }
        return res.toString();
    }
}
