import java.util.*;

public class MostFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 3, 3, 5};
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }

        System.out.println(Arrays.toString(res.toArray(new Integer[0])));
    }
}
