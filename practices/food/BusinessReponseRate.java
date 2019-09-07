import java.util.Map;
import java.util.HashMap;

public class BusinessReponseRate {
    public static void main(String[] args) {
        MyMessage[] messages = new MyMessage[6];
        int[] sender = {1, 42, 2, 2, 3, 3};
        int[] recipient = {42, 1, 42, 42, 88, 42};
        int[] con = {1, 1, 2, 2, 3, 4};

        for (int i = 0; i < 6; i++) {
            messages[i] = new MyMessage(sender[i], recipient[i], con[i]);
        }

        System.out.println(bussiness_resonsiveness_rate(1, messages));
    }

    public static int bussiness_resonsiveness_rate(int biz_owner, MyMessage[] messages) {
        double res = 0;
        Map<Integer, Integer> receive = new HashMap<>();
        Map<Integer, Integer> response = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].sender == biz_owner) {
                if (!response.containsKey(messages[i].conversation_id)) {
                    response.put(messages[i].conversation_id, messages[i].recipient);
                }
            }
            if (messages[i].recipient == biz_owner) {
                if (!receive.containsKey(messages[i].conversation_id)) {
                    receive.put(messages[i].conversation_id, messages[i].sender);
                }
            }
        }
        for (Integer i: receive.keySet()) {
            if (response.containsKey(i)) {
                if (response.get(i).equals(receive.get(i))) {
                    res++;
                }
            }
        }
        res = res / receive.size() * 100;
        return (int)res;
    }
}

class MyMessage {
    public int sender;
    public int recipient;
    public int conversation_id;

    public MyMessage(int s, int r, int c) {
        sender = s;
        recipient = r;
        conversation_id = c;
    }
}