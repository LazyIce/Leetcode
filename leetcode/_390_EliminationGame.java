public class _390_EliminationGame {
    /**
     * time: O(logn)
     * space: O(1)
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remain = n;
        int step = 1;
        int res = 1; // keep the head of the list, when length of list is 1, head is the result
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                res = res + step;
            }
            remain = remain / 2;
            step = step * 2;
            left = !left;
        }

        return res;
    }
}
