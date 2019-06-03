import java.util.List;
import java.util.ArrayList;

public class _57_InsertInterval {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null)
            return intervals;

        List<int[]> res = new ArrayList<>();
        int i = 0;
        // no overlapping for interval and newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the union of intervals we got
        res.add(newInterval);
        // add all the rest
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
