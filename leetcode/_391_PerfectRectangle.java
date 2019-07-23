import java.util.Set;
import java.util.HashSet;

public class _391_PerfectRectangle {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
            return false;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String s1 = rect[0] + "," + rect[1];
            String s2 = rect[0] + "," + rect[3];
            String s3 = rect[2] + "," + rect[3];
            String s4 = rect[2] + "," + rect[1];
            // all the vertex on the adjacent edges will be removed
            if (!set.add(s1))
                set.remove(s1);
            if (!set.add(s2))
                set.remove(s2);
            if (!set.add(s3))
                set.remove(s3);
            if (!set.add(s4))
                set.remove(s4);
        }
        // there are only four points in the set
        if (!set.contains(x1 + "," + y1) || !set.contains(x1 + "," + y2)
                || !set.contains(x2 + "," + y1) || !set.contains(x2 + "," + y2) || set.size() != 4)
            return false;
        // the area of the rectangle can be calculated by the left-bottom point and right-up point
        return area == (x2 - x1) * (y2 - y1);
    }
}
