import java.util.Arrays;

public class ParkingDilemma {
    public static void main(String[] args) {
        int[] cars = new int[] {2, 10, 8, 17};
        System.out.println(carParkingRoot(cars, 3));
    }

    public static int carParkingRoot(int[] cars, int k) {
        Arrays.sort(cars);
        int res = cars[k - 1] - cars[0];
        for (int i = k; i < cars.length; i++) {
            res = Math.min(res, cars[i] - cars[i - k + 1]);
        }

        return res;
    }
}
