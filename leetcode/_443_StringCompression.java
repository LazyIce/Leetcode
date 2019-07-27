public class _443_StringCompression {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int compress(char[] chars) {
        int res = 0, index = 0;
        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[res++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}
