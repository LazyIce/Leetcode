import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CutTheSticks {
    public static  List<Integer> cutSticks(int[] sticks) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(sticks);
        int cut = -1;
        for (int i = 0; i < sticks.length; i++) {
            if (cut < sticks[i]) {
                res.add(sticks.length - i);
                cut = sticks[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sticks  = new int[]{5, 4, 4, 2, 2, 8};
        List<Integer> res = cutSticks(sticks);
        for (int len : res)
            System.out.println(len);
    }
}
