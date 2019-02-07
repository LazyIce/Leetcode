/**
 * time: O(nlogn)
 * space: O(1)
 */

import java.util.Arrays;

public class AmazonClosestTwoSum {
    public static double[] getTwoSumClosest(int numContainers, double maxCapacity, double[] containerWeight) {
        double[] res = new double[2];
        Arrays.sort(containerWeight);
        int low = 0, high = numContainers - 1;
        double diff = Double.MAX_VALUE;

        while (low < high) {
            double sum = containerWeight[low] + containerWeight[high];
            if (sum > maxCapacity) {
                high--;
            } else {
                if (maxCapacity - containerWeight[low] - containerWeight[high] < diff) {
                    res[0] = containerWeight[low];
                    res[1] = containerWeight[high];
                }
                low++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int numContainers = 6;
        double maxCapacity = 43.3;
        double[] containerWight = new double[] {7.33,8.13,103.7313,11.24,23.79,18.350};
        double[] res = getTwoSumClosest(numContainers, maxCapacity, containerWight);
        System.out.print(res[0] + " " +  res[1]);
    }
}
