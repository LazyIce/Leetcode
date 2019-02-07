/**
 * time: Elog(E)
 */

import java.util.*;

class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}

public class AmazonCityConnection {
    private static int unionNum;

    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {

        if (connections == null || connections.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Connection> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        unionNum = 0;
        for (Connection c : connections) {
            String a = c.node1;
            String b = c.node2;

            if (union(map, a, b)) {
                result.add(c);
            }
        }

        String find = connections.get(0).node1;
        int union = map.get(find);
        for (String str : map.keySet()) {
            if (map.get(str) != union) {
                return new ArrayList<>();
            }
        }
        Collections.sort(result, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.node1.equals(o2.node1)) {
                    return o1.node2.compareTo(o2.node2);
                }
                return o1.node1.compareTo(o2.node1);
            }
        });
        return result;
    }

    private static boolean union(Map<String, Integer> map, String a, String b) {
        if (!map.containsKey(a) && !map.containsKey(b)) {
            map.put(a, unionNum);
            map.put(b, unionNum);
            unionNum++;
            return true;
        }

        if (map.containsKey(a) && !map.containsKey(b)) {
            int aU = map.get(a);
            map.put(b, aU);
            return true;
        }
        if (!map.containsKey(a) && map.containsKey(b)) {
            int bU = map.get(b);
            map.put(a, bU);
            return true;
        }

        int aU = map.get(a);
        int bU = map.get(b);

        if (aU == bU) return false;

        for (String s : map.keySet()) {
            if (map.get(s) == bU) map.put(s, aU);
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();

        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 2));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 16));

        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res) {
            System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
        }
    }
}