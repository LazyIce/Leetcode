import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class _963_MinimumAreaRectangleII {
    public double minAreaFreeRect(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] p : points){
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        double min = Double.MAX_VALUE;
        int n = points.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for (int k = j + 1; k < n; k++){
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    if (ver(p1, p2, p3)){
                        int[] temp = p4(p1, p2, p3);
                        if (map.containsKey(temp[0]) && map.get(temp[0]).contains(temp[1])){
                            min = Math.min(min, area(p1, p2, p3));
                        }
                    }
                    if (ver(p2, p1, p3)){
                        int[] temp1 = p4(p2, p1, p3);
                        if (map.containsKey(temp1[0]) && map.get(temp1[0]).contains(temp1[1])){
                            min = Math.min(min, area(p2, p1, p3));
                        }
                    }
                    if (ver(p3, p2, p1)){
                        int[] temp2 = p4(p3, p2, p1);
                        if (map.containsKey(temp2[0]) && map.get(temp2[0]).contains(temp2[1])){
                            min = Math.min(min, area(p3, p2, p1));
                        }
                    }
                }
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }

    public int[] p4(int[] p1, int[] p2, int[] p3){ // find point p4
        return new int[]{p3[0] - p1[0] + p2[0], p3[1] - p1[1] + p2[1]};
    }

    public boolean ver(int[] p1, int[] p2, int[] p3){//detemine vector p1p2 and vector p1p3 are vertical or not
        int x1 = p2[0] - p1[0], y1 = p2[1] - p1[1];
        int x2 = p3[0] - p1[0], y2 = p3[1] - p1[1];
        return x1 * x2 + y1 * y2 == 0;
    }

    public double area(int[] p1, int[] p2, int[] p3){
        int x1 = p2[0] - p1[0], y1 = p2[1] - p1[1];
        int x2 = p3[0] - p1[0], y2 = p3[1] - p1[1];
        return Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2);
    }
}
