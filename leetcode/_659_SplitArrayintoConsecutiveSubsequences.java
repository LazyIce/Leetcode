import java.util.Map;
import java.util.HashMap;

public class _659_SplitArrayintoConsecutiveSubsequences {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isPossible1(int[] nums) {
        int c1 = 1, c2 = 0, c3 = 0; // curr val, len=1, len=2, len=3+
        int p1 = 0, p2 = 0, p3 = 0; // prev val, len=1, len=2, len=3+
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                // curr remains the same
                if (p1 > 0) {
                    p1--;
                    c2++;
                } else if (p2 > 0) {
                    p2--;
                    c3++;
                } else if (p3 > 0) {
                    p3--;
                    c3++;
                } else {
                    c1++;
                }
            } else if (nums[i] == nums[i-1] + 1) {
                // curr + 1, old curr becomes prev
                if (p1 > 0 || p2 > 0) {
                    return false;
                }
                p1 = c1;
                p2 = c2;
                p3 = c3;
                c1 = 0;
                c2 = 0;
                c3 = 0;
                if (p1 > 0) {
                    p1--; c2++;
                } else if (p2 > 0) {
                    p2--; c3++;
                } else if (p3 > 0) {
                    p3--; c3++;
                } else {
                    c1++;
                }
            } else {
                // curr jumps, old curr and old prev should be deprecated
                if (c1 > 0 || c2 > 0) {
                    return false;
                }
                p1 = p2 = p3 = c1 = c2 = c3 = 0;
                c1 = 1;
            }
        }
        return c1 == 0 && c2 == 0;
    }

    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendfreq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i,0) + 1);
        }
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            } else if (appendfreq.getOrDefault(i,0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            } else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
