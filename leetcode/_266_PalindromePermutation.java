public class _266_PalindromePermutation {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        int[] letters = new int[256];
        for (char c : s.toCharArray()) {
            if (letters[c] > 0)
                letters[c]--;
            else
                letters[c]++;
        }
        int res = 0;
        for (int i = 0; i < 256; i++) {
            if (letters[i] != 0)
                res++;
        }

        return res <= 1;
    }
}
