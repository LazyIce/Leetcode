import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _229_MajorityElementII {
    /**
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > count)
                res.add(entry.getKey());
        }

        return res;
    }

    /**
     * Boyer-Moore Majority
     * The essential concepts is you keep a counter for the majority number X.
     * If you find a number Y that is not X, the current counter should deduce 1.
     * The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than Y.
     * This could be explained as "4 X being paired out by 4 Y".
     * time: O(n)
     * space: O(1)
     */
    public List<Integer> majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // the result has at most 2 numbers
        int number1 = 0, number2 = 0;
        int count1 = 0, count2 = 0;
        // begin voting, get the two numbers with highest voting
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // revoting, since the element with second highest ocurrances may not be answer.
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(number1);
        }
        if (count2 > nums.length / 3) {
            res.add(number2);
        }
        return res;
    }
}
