import java.util.Arrays;

public class MeetingRoomes {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        int end = intervals[0].end;
        for (int i = 1; i< intervals.length; i++) {
            if (intervals[i].start < end)
                return false;
            end = Math.max(end, intervals[i].end);
        }
        return true;
    }
}
