import java.util.List;
import java.util.ArrayList;

public class BusinessOpenHours {
    public static void main(String[] args) {
        List<float[]> open = new ArrayList<>();
        open.add(new float[]{0, 2});
        open.add(new float[]{20, 24});
        System.out.println(getFraction(0, 24, open));
    }

    public static float getFraction(float start, float end, List<float[]> open) {
        float res = 0;

        for (float[] interval : open) {
            if (start >= interval[0] && end <= interval[1]) {
                res += (end - start);
            } else if (start < interval[0] && end <= interval[1]) {
                res += (end - interval[0]);
            } else if (start >= interval[0] && end > interval[1]) {
                res += (interval[1] - start);
            } else {
                continue;
            }
        }

        return res / (end - start);
    }
}
