import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return pq.size();
    }
}
