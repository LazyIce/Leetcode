import java.util.*;

public class BusinessLocation {
    public static void main(String[] args) {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("Walmart", "San Jose", 1));
        stores.add(new Store("Walmart", "Los Angeles", 2));
        stores.add(new Store("Bestbuy", "San Jose", 3));
        stores.add(new Store("Bestbuy", "Los Angeles", 4));
        stores.add(new Store("Bestbuy", "Dallas", 5));
        stores.add(new Store("Bed&Bath", "San Jose", 6));
        stores.add(new Store("Bestbuy", "San Jose", 7));
        stores.add(new Store("Bestbuy", "San Jose", 8));
        stores.add(new Store("Walmart", "San Jose", 9));
        stores.add(new Store("Walgreen", "San Jose", 10));
        stores.add(new Store("Walgreen", "San Jose", 11));
        List<Map.Entry<String, Integer>> res = findStores(stores, "San Jose");
        for (Map.Entry<String, Integer> mapping : res) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }

    public static List<Map.Entry<String,Integer>> findStores(List<Store> stores, String city) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).city.equals(city)) {
                if (map.containsKey(stores.get(i).name)) {
                    Integer temp = map.get(stores.get(i).name);
                    map.put(stores.get(i).name, temp + 1);
                } else {
                    map.put(stores.get(i).name, 1);
                }
            }
        }
        List<Map.Entry<String,Integer>> res = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(res, (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue());
        return res;
    }
}

class Store {
    String name;
    String city;
    int businessID;

    public Store(String n, String c, int b) {
        name = n;
        city = c;
        businessID = b;
    }
}
