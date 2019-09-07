public class AutoScalePolicy {
    public static void main(String[] args) {
        int instances = 1;
        int[] averageUtil = new int[] {5, 10, 80};
        System.out.println(getInstances(instances, averageUtil));
    }

    public static int getInstances(int instances, int[] averageUtil) {
        int res = instances;

        for (int i = 0; i < averageUtil.length; i++) {
            if (averageUtil[i] > 60 && res * 2 <= (2 * Math.pow(10, 8))) {
                res *= 2;
                i += 10;
            } else if (averageUtil[i] < 25 && res > 1) {
                res = (int)Math.ceil(res / 2.0);
                i += 10;
            } else {
                continue;
            }
        }

        return res;
    }
}
