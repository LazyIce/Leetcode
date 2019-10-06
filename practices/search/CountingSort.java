import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 3, 2, 8, 5, 9};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
