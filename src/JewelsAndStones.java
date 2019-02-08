/**
 * time: O(mn)
 * space: O(n)
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        char[] stones = S.toCharArray();
        for (char stone: stones) {
            if (J.indexOf(stone + "") != -1)
                res++;
        }
        return res;
    }
}
