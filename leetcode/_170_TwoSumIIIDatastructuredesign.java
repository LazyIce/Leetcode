import java.util.Map;
import java.util.HashMap;

public class _170_TwoSumIIIDatastructuredesign {
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public _170_TwoSumIIIDatastructuredesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            if (map.containsKey(value - key)) {
                if (key == value - key && map.get(key) < 2)
                    continue;
                else
                    return true;
            }
        }

        return false;
    }
}
