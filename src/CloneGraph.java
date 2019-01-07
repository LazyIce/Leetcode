/**
 * time: O(E)
 * space: O(N)
 */
import java.util.Map;
import java.util.HashMap;

public class CloneGraph {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        UndirectedGraphNode curr = new UndirectedGraphNode(node.label);
        map.put(node, curr);
        for (UndirectedGraphNode nei : node.neighbors){
            if (!map.containsKey(nei)){
                cloneGraph(nei);
            }
            curr.neighbors.add(map.get(nei));
        }
        return curr;
    }
}
