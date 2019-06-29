import java.util.Arrays;
import java.util.PriorityQueue;

public class _253_MeetingRoomII {
    /**
     * Like Sweep line
     * time: O(nlogn)
     * space: O(n)
     *
     * concat the continuous segment, put them in the heap
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = heap.poll();
            if (intervals[i][0] >= lastInterval[1]) {
                lastInterval[1] = intervals[i][1];
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(lastInterval);
        }

        return heap.size();
    }
}
