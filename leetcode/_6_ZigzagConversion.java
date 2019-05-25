public class _6_ZigzagConversion {
    /**
     * time complexity: O(n)
     * sapce complexity: O(n)
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        // keep strings for each row
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            // The zigzag repeats by interval.
            // The length of a interval is 2 * numRows - 2
            int index = i % (2 * numRows - 2);
            // Consider the step in a interval is larger, the row index is smaller.
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}
