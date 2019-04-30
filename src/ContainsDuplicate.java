import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<Integer, Integer> ();
        int len = nums.length;

        for (int i = 0; i < len; i++){
            if (HM.containsKey(nums[i])){
                return true;
            }
            else{
                HM.put(nums[i], i+1);
            }
        }

        return false;
    }
}
