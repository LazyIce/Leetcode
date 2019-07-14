public class _345_ReverseVowelsofaString {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(n)
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        String vowels = "aeiouAEIOU";
        char[] strArr = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(strArr[start]) == -1)
                start++;
            while (start < end && vowels.indexOf(strArr[end]) == -1)
                end--;
            char temp = strArr[start];
            strArr[start] = strArr[end];
            strArr[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(strArr);
    }
}
