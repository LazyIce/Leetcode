import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 3, 2, 8, 5, 9};
        int bins = 5;
        List<Integer>[] buckets = new List[bins];
        for (int i = 0; i < bins; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i] / 2].add(arr[i]);
        }
        for (int i = 0; i < bins; i++) {
            Collections.sort(buckets[i]);
        }
        int k = 0;
        for (int i = 0; i < bins; i++) {
            for (Integer num : buckets[i]) {
                arr[k++] = num;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
