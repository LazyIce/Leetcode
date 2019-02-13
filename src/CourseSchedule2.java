import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int count = numCourses;

        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count--;
            res.add(pre);
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0)
                        queue.offer(pair[0]);
                }
            }
        }

        if (count != 0) {
            return new int[0];
        } else {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] courses = new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = findOrder(4, courses);
        System.out.print(res.toString());
    }
}
