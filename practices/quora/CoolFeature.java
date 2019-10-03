import java.util.*;

public class CoolFeature {
    public static void main(String[] agrs) {
        int[] a = new int[] {1, 2, 3};
        int[] b = new int[] {3, 4};
        int[][] query = new int[][] {{1, 5}, {1, 1, 1}, {1, 5}};


        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            setA.add(a[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            if (query[i].length == 2) {
                int count = 0;
                for (int j = 0; j < query[0].length; j++) {
                    for (int num : b) {
                        if (setA.contains(query[i][1] - num)) {
                            count++;
                        }
                    }
                }
                res.add(count);
            } else {
                b[query[i][1]] = query[i][2];
            }

        }

        System.out.println(Arrays.toString(res.toArray(new Integer[0])));
    }
}
