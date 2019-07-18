public class _357_CountNumberwithUniqueDigits {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(1)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigit = 9;
        int availableNumber = 9;

        while (n-- > 1 && availableNumber > 0) {
            uniqueDigit = uniqueDigit * availableNumber;
            res += uniqueDigit;
            availableNumber--;
        }

        return res;
    }
}
