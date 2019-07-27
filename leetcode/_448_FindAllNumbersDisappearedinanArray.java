import java.util.List;
import java.util.ArrayList;

public class _448_FindAllNumbersDisappearedinanArray {
    /**
     * time: O(n)
     * space: O(1)
     * We iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
     * In this way all the numbers that we have seen will be marked as negative.
     * In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
