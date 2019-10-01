public class WateringFlowers {
    public static void main(String[] args) {
        int[] flowers = new int[] {2, 4, 5, 1, 2};
        System.out.println(getSteps(flowers, 6));
    }

    public static int getSteps(int[] flowers, int cap) {
        if (flowers == null || flowers.length == 0) {
            return 0;
        }

        int steps = 0;
        int can = cap;
        for (int i = 0; i < flowers.length; i++) {
            if (cap < flowers[i]) {
                return -1;
            }

            if (flowers[i] <= can) {
                steps++;
                can -= flowers[i];
            } else {
                steps += (i * 2 + 1);
                can = cap - flowers[i];
            }
        }

        return steps;
    }
}
