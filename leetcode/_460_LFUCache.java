import java.util.Map;
import java.util.HashMap;

public class _460_LFUCache {
    class DLLNode {
        int key;
        int val;
        int cnt;
        DLLNode prev;
        DLLNode next;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    class DLList {
        DLLNode head;
        DLLNode tail;
        int size;

        DLList() {
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(DLLNode node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(DLLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        DLLNode removeLast() {
            if (size > 0) {
                DLLNode node = tail.prev;
                remove(node);
                return node;
            } else {
                return null;
            }
        }
    }

    int capacity;
    int size;
    int min;
    Map<Integer, DLLNode> nodeMap;
    Map<Integer, DLList> countMap;

    public _460_LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        DLLNode node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            node = new DLLNode(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countMap.put(node.cnt, newList);
        }
    }

    private void update(DLLNode node) {
        DLList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        if (node.cnt == min && oldList.size == 0) {
            min++;
        }
        node.cnt++;
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }
}
