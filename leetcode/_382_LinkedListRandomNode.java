import java.util.Random;

public class _382_LinkedListRandomNode {
    class Solution {
        private ListNode head;
        private Random rand;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            rand = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode dummy = head;
            int res = dummy.val;
            int i = 1;
            while (dummy.next != null) {
                dummy = dummy.next;
                if (rand.nextInt(++i) == 0)
                    res = dummy.val;
            }

            return res;
        }
    }
}
