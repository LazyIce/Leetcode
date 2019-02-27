import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0)
            return new int[0];
        int[] time = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int last = 0;
        for (String log : logs) {
            String[] s = log.split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    time[stack.peek()] += Integer.valueOf(s[2]) - last;
                }
                stack.push(Integer.valueOf(s[0]));
                last = Integer.valueOf(s[2]);
            } else {
                time[stack.pop()] += Integer.valueOf(s[2]) - last + 1;
                last = Integer.valueOf(s[2]) + 1;
            }
        }
        return time;
    }
}
