import java.util.TreeMap;
import java.util.Map;

public class _853_CarFleet {
    /**
     * time: O(nlogn)
     * space: O(n)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for(int i = 0; i < n; i++) {
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1.0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int d = entry.getKey(); // distance
            int s = entry.getValue(); // speed
            double t = 1.0 * d / s; // time to target
            if(t > r){ // this car is unable to catch up previous one, form a new group and update the value
                count++;
                r = t;
            }
        }
        return count;
    }
}
