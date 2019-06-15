public class RandomListNode {
    public int val;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode() {}

    public RandomListNode(int _val,RandomListNode _next,RandomListNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
