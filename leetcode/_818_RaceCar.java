import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class _818_RaceCar {
    public int racecar(int target) {
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[] {0, 1});
        visited.add(0 + "," + 1);

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == target) {
                    return level;
                }
                int newPos = cur[0] + cur[1];
                int newSpeed = cur[1] << 1;
                int[] next = new int[] {newPos, newSpeed};
                String key = newPos + "," + newSpeed;
                if (!visited.contains(key) && newPos > 0 && newPos < (target * 2)) {
                    visited.add(key);
                    queue.offer(new int[] {newPos, newSpeed});
                }
                newPos = cur[0];
                newSpeed = (cur[1] > 0) ? -1 : 1;
                key = newPos + "," + newSpeed;
                if (!visited.contains(key) && newPos > 0 && newPos < (target * 2)) {
                    visited.add(key);
                    queue.offer(new int[] {newPos, newSpeed});
                }
            }
            level++;
        }

        return -1;
    }
}
