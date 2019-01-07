import java.util.Map;
import java.util.HashMap;

public class CopyListWithRandomPointer {
    /**
     * time: O(n)
     * space: O(n)
     */
    //Using HashMap
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            cur.next = map.get(head);
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    // No HashMap
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyPrev = dummy;
        while (cur != null) {
            copyPrev.next = cur.next;
            cur.next = cur.next.next;
            copyPrev = copyPrev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
