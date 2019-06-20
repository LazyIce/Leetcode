public class _186_ReverseWordsinaStringII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
            // handle for the last word
            if (i == s.length - 1)
                reverse(s, start, i);
        }
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
