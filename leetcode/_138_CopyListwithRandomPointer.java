import java.util.Map;
import java.util.HashMap;

public class _138_CopyListwithRandomPointer {
    /**
     * time: O(n)
     * space: O(n)
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null)
            return null;

        // save the origin node and clone node in the map
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        // create a copy for every node
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.val, null, null));
            cur = cur.next;
        }
        // deep copy the new list
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode cur = head, next;

        // First round: make copy of each node, and link them together side-by-side in a single list.
        while (cur != null) {
            next = cur.next; // keep the cur.next
            RandomListNode copy = new RandomListNode(cur.val, null, null); // copy node
            cur.next = copy;  // link original node to copy node
            copy.next = next;  // link copy node to original node
            cur = next; // go to next node
        }

        // Second round: assign random pointers for the copy nodes.
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        cur = head;
        RandomListNode dummy = new RandomListNode(0, null, null);
        RandomListNode copy, copyIter = dummy;

        while (cur != null) {
            next = cur.next.next;
            // extract the copy
            copy = cur.next;
            copyIter.next = copy;
            copyIter = copy;
            // restore the original list
            cur.next = next;
            cur = next;
        }

        return dummy.next;
    }
}
