public class _1055_ShortestWaytoFormString {
    /**
     * time: O(m*n)
     * space: O(m+n)
     */
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray();
        char[] ct = target.toCharArray();
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < ct.length) {
            int prev = j;
            while (i < cs.length && j < ct.length) {
                if (cs[i] == ct[j]) {
                    j++;
                }
                i++;
            }
            if (prev == j) {
                return -1;
            }
            res++;
            i = 0;
        }

        return res;
    }
}
