import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class _403_FrogJump {
    /**
     * Dynamic Programming
     * time: O(n^2)
     * space: O(n^2)
     */
    public boolean canCross(int[] stones) {
        // key is the stone, value is the jump step
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int unit: map.get(stones[i])) {
                for (int step = unit - 1; step <= unit + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
