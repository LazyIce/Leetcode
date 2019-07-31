public class _458_PoorPigs {
    /**
     * time: O(1)
     * space: O(1)
     */
    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int num = minutesToTest / minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(num));
    }

    /**
     * time: O(1)
     * space: O(1)
     */
    public int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
        int res = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, res) < buckets) {
            res += 1;
        }
        return res;
    }
}
