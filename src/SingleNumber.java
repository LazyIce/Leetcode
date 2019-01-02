/**
 * time: O(n)
 * space: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int b = 0;
        for(int a: nums){
            b = ~b & a | b & ~a;
        }
        return b;
    }
}
