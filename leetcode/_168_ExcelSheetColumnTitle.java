public class _168_ExcelSheetColumnTitle {
    /**
     * time: O(logn)
     * space: O(1)
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
