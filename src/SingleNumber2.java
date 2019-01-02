import java.util.Set;
import java.util.HashSet;

public class SingleNumber2 {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum1 += num;
            set.add(num);
        }
        for (int entry : set) {
            sum2 += entry;
        }
        int res = (int)((sum2 * 3 - sum1) / 2);
        return res;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int singleNumber2(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
