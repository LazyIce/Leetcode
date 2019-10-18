import java.util.*;

public class NoLapIntervalSumEqualsK {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 2, 2, 2};
        int k = 6;

        List<int[]> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> init = new ArrayList<>();
        init.add(-1);
        map.put(0, init);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum - k)) {
                List<Integer> list = map.get(sum - k);
                for (Integer index : list) {
                    res.add(new int[]{index + 1, i});
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }

        Collections.sort(res, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        System.out.println(Arrays.toString(res.get(0)));
        System.out.println(Arrays.toString(res.get(1)));
    }
}
