public class _151_ReverseWordsinaString {
    /**
     * time: O(n)
     * space: O(n)
     */
    public String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }

    /**
     * Two Pointers
     * time: O(n)
     * space: O(n)
     */
    public String reverseWords2(String s) {
        char[] chs = s.toCharArray();
        reverse(chs, 0, s.length() - 1);
        reverseWord(chs, s.length());
        return cleanSpaces(chs, s.length());
    }

    public void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }

    public void reverseWord(char[] chs, int len) {
        int i = 0, j = 0;
        while (i < len) {
            // i < j to move the start pointer to catch the last end pointer
            while (i < j || i < len && chs[i] == ' ')
                i++;
            // j < i to move the end pointer to catch the new start
            while (j < i || j < len && chs[j] != ' ')
                j++;
            reverse(chs, i, j - 1);
        }
    }

    public String cleanSpaces(char[] chs, int len) {
        int i = 0, j = 0;
        while (j < len) {
            while (j < len && chs[j] == ' ')
                j++;
            while (j < len && chs[j] != ' ')
                chs[i++] = chs[j++];
            while (j < len && chs[j] == ' ')
                j++;
            if (j < len) {
                chs[i++] = ' ';
            }
        }
        return String.valueOf(chs).substring(0, i);
    }
}
