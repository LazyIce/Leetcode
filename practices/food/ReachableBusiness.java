import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class ReachableBusiness {
    public static void main(String[] args) {
        Business a = new Business("A", new HashMap<Business, Integer>());
        Business b = new Business("B", new HashMap<Business, Integer>());
        Business c = new Business("C", new HashMap<Business, Integer>());
        Business d = new Business("D", new HashMap<Business, Integer>());
        Business e = new Business("E", new HashMap<Business, Integer>());
        Business f = new Business("F", new HashMap<Business, Integer>());
        Business g = new Business("G", new HashMap<Business, Integer>());
        Business h = new Business("H", new HashMap<Business, Integer>());
        a.nearby_business.put(b, 2);
        a.nearby_business.put(c, 4);
        b.nearby_business.put(a, 2);
        b.nearby_business.put(d, 5);
        c.nearby_business.put(a, 4);
        List<String> res = find_reachable_businesses(a, 7);
        for (String s: res)
            System.out.print(s + " ");
        System.out.println("");
    }

    public static List<String> find_reachable_businesses(Business starting_business, int distance) {
        List<String> res = new ArrayList<>();

        Map<String, Integer> dis = new HashMap<>();
        dis.put(starting_business.name, 0);

        Set<String> visited = new HashSet<>();
        Queue<Business> q = new LinkedList<>();
        q.add(starting_business);

        while (!q.isEmpty()) {
            Business root = q.poll();
            visited.add(root.name);
            for (Business nearby: root.nearby_business.keySet()) {
                if (!visited.contains(nearby.name)) {
                    q.add(nearby);
                    if (dis.containsKey(nearby.name)) {
                        int newdis = dis.get(root.name) + root.nearby_business.get(nearby);
                        if (newdis < dis.get(nearby.name)) {
                            dis.put(nearby.name, newdis);
                        }
                    } else {
                        dis.put(nearby.name, root.nearby_business.get(nearby));
                    }
                }
            }
        }

        for (String name: dis.keySet()) {
            if (dis.get(name) <= distance && !name.equals(starting_business.name)) {
                res.add(name);
            }
        }

        return res;
    }
}


class Business {
    public String name;
    public Map<Business, Integer> nearby_business;

    public Business(String name, Map<Business, Integer> nearby_business) {
        this.name = name;
        this.nearby_business = nearby_business;
    }
}