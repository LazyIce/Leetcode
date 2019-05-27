import java.util.Queue;
import java.util.PriorityQueue;

public class _23_MergekSortedLists {
    /**
     * Priority Queue (min heap)
     * time: O(nlogk), k is the number of linked lists
     * space: O(n)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            // priority queue can't add null
            if (list != null) {
                pq.offer(list);
            }
        }

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            // add the next node in the current linked list
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }

        return dummy.next;
    }

    /**
     * Merge Sort
     * time: O(nlogk)
     * space: O(n)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high)
            return lists[low];
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
