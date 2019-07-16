import java.util.TreeMap;

public class _352_DataStreamasDisjointIntervals {
    /**
     * TreeMap
     * time: O(logn)
     * space: O(n)
     */
    class SummaryRanges {
        private TreeMap<Integer, int[]> treeMap;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            if (treeMap.containsKey(val))
                return;
            Integer lowerKey = treeMap.lowerKey(val);
            Integer higherKey = treeMap.higherKey(val);
            if (lowerKey != null && higherKey != null && treeMap.get(lowerKey)[1] + 1 == val && val + 1 == treeMap.get(higherKey)[0]) {
                treeMap.get(lowerKey)[1] = treeMap.get(higherKey)[1];
                treeMap.remove(higherKey);
            } else if (lowerKey != null && val <= treeMap.get(lowerKey)[1] + 1) {
                treeMap.get(lowerKey)[1] = Math.max(treeMap.get(lowerKey)[1], val);
            } else if (higherKey != null && treeMap.get(higherKey)[0] - 1 == val) {
                treeMap.put(val, new int[]{val, treeMap.get(higherKey)[1]});
                treeMap.remove(higherKey);
            } else {
                treeMap.put(val, new int[]{val, val});
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[treeMap.size()][2];
            int i = 0;
            for (int[] interval : treeMap.values()) {
                res[i++] = interval;
            }
            return res;
        }
    }
}
