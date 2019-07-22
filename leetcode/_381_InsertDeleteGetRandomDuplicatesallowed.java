import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class _381_InsertDeleteGetRandomDuplicatesallowed {
    class RandomizedCollection {
        private Map<Integer, Set<Integer>> map;
        private List<Integer> list;
        private Random rand;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean isContain = map.containsKey(val);
            if (!isContain)
                map.put(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return !isContain;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (map.get(val).size() == 0)
                map.remove(val);
            int lastVal = list.remove(list.size() - 1);
            if (index != list.size()) {
                list.set(index, lastVal);
                map.get(lastVal).remove(list.size());
                map.get(lastVal).add(index);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

}
