import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _621_TaskScheduler {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            // map key is TaskName, and value is number of times to be executed.
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( //frequency sort
                (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        pq.addAll(map.entrySet());

        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry> tempList = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> top = pq.poll(); // most frequency task
                top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
                tempList.add(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0)
                    pq.add(e); // add valid tasks
            }

            if (pq.isEmpty())
                break;
            count = count + k; // if k > 0, then it means we need to be idle
        }

        return count;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int leastInterval2(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            }
            else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
