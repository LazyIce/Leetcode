import java.util.Map;
import java.util.HashMap;

public class _149_MaxPointsonaLine {
    /**
     * time: O(n^2)
     * space: O(n)
     */
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length <= 2)
            return points.length;

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int lineMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                // consider precision, we use x / y string format to keep slope
                String slope = String.valueOf(x) + "/" + String.valueOf(y);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                lineMax = Math.max(lineMax, map.get(slope));
            }

            res = Math.max(res, lineMax + samePoint + 1);
        }

        return res;
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
