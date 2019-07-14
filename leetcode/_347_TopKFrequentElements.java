import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _347_TopKFrequentElements {
    /**
     * hashmap + maxHeap
     * time: O(nlogn)
     * space: O(n)
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        // key is the num, value is the count of num
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // use maxHeap to sort the frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        // get the answer
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }

        return res;
    }

    /**
     * Bucket Sort
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        // key is the num, value is the count of num
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // use bucket for different freqency
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        // get the answer
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }
}
