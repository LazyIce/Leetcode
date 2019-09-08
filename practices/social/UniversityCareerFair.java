public class UniversityCareerFair {
    public static void main(String[] args) {
        int[] arrival = new int[] {1, 3, 3, 5, 7};
        int[] duration = new int[] {2, 2, 1, 2, 1};
        System.out.println(getMaxEvents(arrival, duration));
    }

    public static int getMaxEvents(int[] arrival, int[] duration) {
        int res = 1;
        int minIndex = 0;
        for (int i = 1; i < arrival.length; i++) {
            if (arrival[minIndex] + duration[minIndex] <= arrival[i]) {
                res++;
                minIndex = i;
                while (i + 1 < arrival.length && arrival[i + 1] == arrival[i]) {
                    if (duration[i + 1] < duration[i]) {
                        minIndex = i + 1;
                    }
                    i++;
                }
            }
        }

        return res;
    }
}
