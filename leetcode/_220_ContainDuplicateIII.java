import java.util.TreeSet;
import java.util.HashMap;

public class _220_ContainDuplicateIII {
    /**
     * TreeSet
     * time: O(nlogk)
     * space: O(k)
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;
            set.add((long)nums[i]);
            if (i >= k)
                set.remove((long)nums[i - k]);
        }

        return false;
    }

    /**
     * Bucket Sort
     * time: O(n)
     * space: O(k)
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            // check for same bucket and adjacent bucket
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
