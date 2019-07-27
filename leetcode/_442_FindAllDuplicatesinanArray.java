import java.util.List;
import java.util.ArrayList;

public class _442_FindAllDuplicatesinanArray {
    /**
     * time: O(n)
     * space: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }

        return res;
    }
}
