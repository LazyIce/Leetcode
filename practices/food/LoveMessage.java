import java.util.*;

public class LoveMessage {
    public static void main(String[] args) {
        Comment[] c‍‍‍‌‌‌‌‍‌‌‍‌‌‍‌‌‍‍‍omments = new Comment[]{
                new Comment("A", "great", "X"),
                new Comment("A", "great1", "X"),
                new Comment("A", "great2", "X"),
                new Comment("B", "great3", "X"),
                new Comment("B", "great4", "Y"),
                new Comment("B", "great5", "Z"),
                new Comment("C", "great5", "X"),
                new Comment("C", "great5", "Y")
        };

        String[] topReceivers = getTopKReceiver(c‍‍‍‌‌‌‌‍‌‌‍‌‌‍‌‌‍‍‍omments, 2);
        String[] topReceiversWithoutDuplicate = getTopKReceiverWithoutDuplicates(c‍‍‍‌‌‌‌‍‌‌‍‌‌‍‌‌‍‍‍omments, 2);
        System.out.println(Arrays.toString(topReceivers));
        System.out.println(Arrays.toString(topReceiversWithoutDuplicate));
    }

    public static String[] getTopKReceiver(Comment[] comments, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Comment comment : comments) {
            if (map.containsKey(comment.receiver)) {
                map.put(comment.receiver, map.get(comment.receiver) + 1);
            } else {
                map.put(comment.receiver, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() == a.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            pq.offer(item);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res.toArray(new String[0]);
    }

    public static String[] getTopKReceiverWithoutDuplicates(Comment[] comments, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (Comment comment : comments) {
            Set<String> senders = map.getOrDefault(comment.receiver, new HashSet<>());
            senders.add(comment.sender);
            map.put(comment.receiver, senders);
        }

        PriorityQueue<Map.Entry<String, Set<String>>> pq = new PriorityQueue<>((a, b) -> a.getValue().size() == b.getValue().size() ? b.getKey().compareTo(a.getKey()) : a.getValue().size() - b.getValue().size());

        for (Map.Entry<String, Set<String>> item : map.entrySet()) {
            pq.offer(item);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res.toArray(new String[0]);
    }
}

class Comment {
    String receiver;
    String message;
    String sender;

    public Comment(String receiver, String message, String sender) {
        this.receiver = receiver;
        this.message = message;
        this.sender = sender;
    }
}
