public class _459_RepeatedSubstringPattern {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int num = len / i;
                String substr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(substr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
