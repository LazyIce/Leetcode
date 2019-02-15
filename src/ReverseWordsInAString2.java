public class ReverseWordsInAString2 {
    public void reverseWords(char[] str) {
        int start = 0, i = 0;
        while (i < str.length) {
            start = String.valueOf(str).indexOf(' ', start);
            if (start == -1) {
                reverseString(str, i, str.length - 1);
                i = str.length;
            } else {
                reverseString(str, i, start - 1);
                start++;
                i = start;
            }
        }
        reverseString(str, 0, str.length - 1);
    }

    public void reverseString(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
