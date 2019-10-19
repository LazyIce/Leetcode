import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SpeedInterval {
    public static void main(String[] args) {
        int[][] cars = new int[][] {{5, 10, 20}, {7, 15, 30}, {20, 30, 15}};

        List<int[]> res = getSpeedInterval(cars);
        for (int[] speed : res) {
            System.out.println(Arrays.toString(speed));
        }
    }

    public static List<int[]> getSpeedInterval(int[][] cars) {
        List<int[]> res = new ArrayList<>();

        List<int[]> speeds = new ArrayList<>();
        for (int[] car : cars) {
            speeds.add(new int[] {car[0], -car[2]});
            speeds.add(new int[] {car[1], car[2]});
        }

        Collections.sort(speeds, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int count = 1;
        int sum = -speeds.get(0)[1];
        int prev = speeds.get(0)[0];
        for (int i = 1; i < speeds.size(); i++) {
            if (count != 0) {
                int cur = speeds.get(i)[0];
                res.add(new int[] {prev, cur, sum / count});
                prev = cur;
            }
            int speed = speeds.get(i)[1];
            if (speed < 0) {
                count++;
                sum += (-speed);
            } else {
                count--;
                sum -= speed;
            }
        }

        return res;
    }
}
