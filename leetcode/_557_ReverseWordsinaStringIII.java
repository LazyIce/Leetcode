public class _557_ReverseWordsinaStringIII {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(n)
     */
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < str.length && str[j + 1] != ' ') {
                    j++;
                } // move j to the end of the word
                reverse(str, i, j);
                i = j;
            }
        }

        return new String(str);
    }

    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
