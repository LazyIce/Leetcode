import java.util.Map;
import java.util.HashMap;

public class MyLogger implements Logger {
    class Node {
        String id;
        long start;
        long end;
        Node next;
        Node prev;

        public Node(String id, long start) {
            this.id = id;
            this.start = start;
            end = -1;
        }
    }

    Node head, tail;
    Map<String, Node> map;

    public MyLogger() {
        head = new Node("", -1);
        tail = new Node("", -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void started(long timestamp, String requestId) {
        Node cur = new Node(requestId, timestamp);
        map.put(requestId, cur);
        add(cur);
    }

    public void finished(long timestamp, String requestId) {
        Node cur = map.get(requestId);
        if(cur != null && cur.end == -1) {
            cur.end = timestamp;
            map.remove(requestId);
        }
    }

    public void print() {
        Node cur = head.next;
        while(cur != tail) {
            if(cur.end != -1) {
                System.out.println(cur.id + "start at" + cur.start + " end at " + cur.end);
            }
            cur = cur.next;
        }
    }

    private void add(Node cur) {
        if (cur == null) {
            return;
        }
        cur.next = tail;
        cur.prev = tail.prev;
        tail.prev.next = cur;
        tail.prev = cur;
    }
}

interface Logger {
    void started(long timestamp, String requestId);
    void finished(long timestamp, String requestId);
    void print();
}
