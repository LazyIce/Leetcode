import java.util.List;

public class UndirectedGraphNode {
    public int val;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode() {}

    public UndirectedGraphNode(int _val, List<UndirectedGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}