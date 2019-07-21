import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _380_InsertDeleteGetRandom {
    class RandomizedSet {
        private Map<Integer, Integer> map; // key is the number, value is the index of number in list
        private List<Integer> list;
        private Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            int index = map.remove(val);
            int lastVal = list.remove(list.size() - 1);
            if (index != list.size()) {
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
