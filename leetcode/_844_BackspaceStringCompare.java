public class _844_BackspaceStringCompare {
    /**
     * time: O(N)
     * space: O(1)
     */
    public boolean backspaceCompare1(String S, String T) {
        StringBuilder sb = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        String temp1 = sb.toString();

        sb = new StringBuilder();
        for (Character c : T.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        String temp2 = sb.toString();
        System.out.print(temp2);

        return temp1.equals(temp2);
    }

    /**
     * time: O(N)
     * space: O(1)
     */
    public boolean backspaceCompare2(String S, String T) {
        if (S == null || T == null) {
            return S == T;
        }
        int m = S.length(), n = T.length();
        int i = m - 1, j = n - 1;
        int cnt1 = 0, cnt2 = 0;//number of '#';
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i) == '#') {
                    cnt1++;
                } else {
                    cnt1--;
                }
                i--;
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j) == '#') {
                    cnt2++;
                } else {
                    cnt2--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }
}
