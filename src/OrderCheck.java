import java.util.Arrays;

public class OrderCheck {
    public static int countStudents(int[] nums) {
       int res = 0;
       int[] newArr = Arrays.copyOf(nums, nums.length);
       Arrays.sort(newArr);
       for (int i = 0; i < nums.length; i++) {
           if (newArr[i] != nums[i]) {
               res = nums.length - i;
               break;
           }
       }
       return res;
    }

    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 3, 4, 1};
        int res = countStudents(students);
        System.out.print(res);
    }
}
