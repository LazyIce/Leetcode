import java.util.Arrays;

public class Heaters {
    public static void main(String[] args) {
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = - (index + 1);
                int dists1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dists2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dists1, dists2));
            }
        }
        return result;
    }
}
