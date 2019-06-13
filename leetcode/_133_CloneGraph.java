import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class _133_CloneGraph {
    // use map to check whether the node is visited
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    /**
     * DFS
     * time: O(V+E)
     * space: O(V)
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null)
            return null;
        // use map to store (oldNode, newNode) pair
        return helper(node);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null)
            return null;

        if (map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode dup = new UndirectedGraphNode(node.val, new ArrayList<>());
        map.put(node, dup);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode clone = helper(neighbor);
            dup.neighbors.add(clone);
        }

        return dup;
    }

    /**
     * BFS
     * time: O(V+E)
     * space: O(V)
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.val, new ArrayList<>());
        map.put(node, copy);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (map.containsKey(neighbor))
                    map.get(cur).neighbors.add(map.get(neighbor));
                else {
                    UndirectedGraphNode neighCopy = new UndirectedGraphNode(neighbor.val, new ArrayList<>());
                    map.put(neighbor, neighCopy);
                    map.get(cur).neighbors.add(neighCopy);
                    queue.add(neighbor);
                }
            }
        }

        return copy;
    }
}
