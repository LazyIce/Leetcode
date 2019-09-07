import java.util.*;

public class ActiveBusiness {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event("ads", 7, 3));
        events.add(new Event("ads", 8, 2));
        events.add(new Event("ads", 5, 1));
        events.add(new Event("page_views", 11, 2));
        events.add(new Event("page_views", 12, 3));
        events.add(new Event("photo_views", 10, 1));
        events.add(new Event("reviews", 7, 2));
        List<Integer> res = findActiveBusiness(events);
        for (Integer id : res) {
            System.out.println(id);
        }
    }

    public static List<Integer> findActiveBusiness(List<Event> businessList) {
        Map<String, Integer> event_type = new HashMap<>();
        event_type.put("ads", 0);
        event_type.put("page_views", 1);
        event_type.put("photo_views", 2);
        event_type.put("reviews", 3);

        List<Integer> res = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        Map<Integer, List<Integer>> avg = new HashMap<>();

        for (Event business : businessList) {
            int idx = event_type.get(business.type);
            int[] cntList = map.getOrDefault(business.id, new int[4]);
            cntList[idx] = business.cnt;
            map.put(business.id, cntList);
            List<Integer> avgList = avg.getOrDefault(idx, new ArrayList<>());
            avgList.add(business.cnt);
            avg.put(idx, avgList);
        }


        float[] avgEach = new float[4];
        Arrays.fill(avgEach, 0);
        for (Map.Entry<Integer, List<Integer>> avgItem : avg.entrySet()) {
            int index = avgItem.getKey();
            List<Integer> list = avgItem.getValue();
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            avgEach[index] = (float)(sum / list.size());
        }

        for (Map.Entry<Integer, int[]> item : map.entrySet()) {
            int id = item.getKey();
            int[] types = item.getValue();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (types[i] >= avgEach[i]) {
                    count++;
                }
            }
            if (count >= 2) {
                res.add(id);
            }
        }

        return res;
    }
}

class Event {
    String type;
    int cnt;
    int id;

    public Event(String type, int cnt, int id) {
        this.type = type;
        this.cnt = cnt;
        this.id = id;
    }
}
