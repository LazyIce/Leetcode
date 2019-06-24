import java.util.Set;
import java.util.HashSet;

public class _217_ContainsDuplicate {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }

        return false;
    }
}
