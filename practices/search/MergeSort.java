import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 3, 1, 7, 12, 8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (r - l) / 2 + l;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] tempL = new int[len1];
        int[] tempR = new int[len2];
        for (int i = 0; i < len1; i++) {
            tempL[i] = arr[l + i];
        }
        for (int j = 0; j < len2; j++) {
            tempR[j] = arr[j + m + 1];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (tempL[i] <= tempR[j]) {
                arr[k] = tempL[i];
                i++;
            } else {
                arr[k] = tempR[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = tempL[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = tempR[j];
            j++;
            k++;
        }
    }
}
