import java.util.Map;
import java.util.HashMap;

public class _146_LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public _146_LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // put the used node to the tail
        if (node != tail) {
            if (node == head)
                head = head.next;
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }

        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // chect whether the key is used
        if (node != null) {
            node.val = value;  // update the value
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            // consider the initial state
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
