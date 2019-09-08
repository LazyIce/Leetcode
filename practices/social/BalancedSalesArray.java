public class BalancedSalesArray {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 6};
        System.out.println(balancedSum(array));
    }

    public static int balancedSum(int[] array) {
        int sum = 0;
        for (Integer num : array) {
            sum += num;
        }

        int leftSum = 0;

        for (int i = 1; i < array.length - 1; i++) {
            leftSum += array[i - 1];
            if (leftSum == sum - leftSum - array[i])
                return i;
        }

        return -1;
    }
}
