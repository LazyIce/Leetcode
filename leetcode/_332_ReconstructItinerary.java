import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class _332_ReconstructItinerary {
    /**
     * DFS + Topology Sort
     * time: O(n)
     * space: O(n)
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        for(int i = 0; i < tickets.size(); i ++) {
            String key = tickets.get(i).get(0);
            if(map.get(key) == null) {
                map.put(key, new PriorityQueue<String>());
            }
            map.get(key).offer(tickets.get(i).get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String cur = stack.peek();
            if(map.containsKey(cur) && map.get(cur).size() > 0) {
                stack.push(map.get(cur).poll());
            } else {
                res.addFirst(stack.pop());
            }
        }
        return res;
    }
}
