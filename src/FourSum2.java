/**
 * time: O(n^2)
 * space: O(n)
 */

import java.util.Map;
import java.util.HashMap;

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = -C[i] - D[j];
                res += map.getOrDefault(target, 0);
            }
        }
        return res;
    }
}
