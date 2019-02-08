import java.util.Map;
import java.util.HashMap;
public class MajorityElement {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int majorityElement(int[] nums) {
        int res = 0;
        int base = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > base)
                res = item.getKey();
        }
        return res;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int majorityElement2(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
