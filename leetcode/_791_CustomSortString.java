public class _791_CustomSortString {
    /**
     * time: O(n)
     * space: O(1)
     */
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        // count each char in T.
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // sort chars both in T and S by the order of S.
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        // group chars in T but not in S.
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
