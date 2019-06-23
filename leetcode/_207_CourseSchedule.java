import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class _207_CourseSchedule {
    /**
     * BFS Topology Sort
     * time: O(V+E)
     * space: O(n)
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int res = numCourses;
        // keep the indegree for each node
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        // get the courses which don't need prerequisites initially
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        // find the courses can be finished
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0)
                        queue.offer(pair[0]);
                }
            }
        }

        return res == 0;
    }

    /**
     * DFS
     * time: O(V+E)
     * space: O(n)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        // create the dependency graph
        for(int[] pair : prerequisites) {
            courses.get(pair[1]).add(pair[0]);
        }

        int[] visited = new int[numCourses];
        // dfs visit each course
        for(int i = 0; i < numCourses; i++) {
            if (!dfs(i, courses, visited))
                return false;
        }

        return true;
    }

    public boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
        visited[course] = 1; // mark it being visited
        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for(int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i).intValue();

            if(visited[eligibleCourse] == 1)
                return false; // has been visited while visiting its children - cycle !!!!
            if(visited[eligibleCourse]  == 0) { // not visited
                if (!dfs(eligibleCourse, courses, visited))
                    return false;
            }
        }

        visited[course] = 2; // mark it done visiting
        return true;
    }
}
