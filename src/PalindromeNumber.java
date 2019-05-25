public class PalindromeNumber {
    /**
     * time: O(logx)
     * space: O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;
        int num = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == num;
    }
}
