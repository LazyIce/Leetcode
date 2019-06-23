import java.util.Queue;
import java.util.LinkedList;

public class _210_CourseScheduleII {
    /**
     * BFS Topology Sort
     * time: O(V+E)
     * space: O(n)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        // construct indegree for each course
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        // select the courses without prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        // take course by prerequisites
        int idx = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[idx] = pre;
            idx++;
            // take new courses whose prerequisites are finished
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0)
                        queue.offer(pair[0]);
                }
            }
        }

        return idx == numCourses ? res : new int[0];
    }
}
