import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class _939_MinimumAreaRectangle {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                if (point1[0] == point2[0] || point1[1] == point2[1]) { // if have the same x or y
                    continue;
                }
                if (map.get(point1[0]).contains(point2[1]) && map.get(point2[0]).contains(point1[1])) { // find other two points
                    min = Math.min(min, Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
