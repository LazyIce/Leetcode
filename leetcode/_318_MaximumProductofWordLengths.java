public class _318_MaximumProductofWordLengths {
    /**
     * Bit Manipulation
     * time: O(n^2)
     * space: O(n)
     */
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            // use 32-bit int to represent word
            // a: 00..001, b: 00...010, c: 00...100...
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        for (int i = 0; i < bytes.length - 1; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }

        return res;
    }
}
