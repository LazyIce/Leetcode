import java.util.TreeSet;
public class ProductOfMaxAndMin {
    public static long[] minMax(String[] operations, int[] values) {
        long[] products = new long[operations.length];
        TreeSet<Integer> elements = new TreeSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("push")) {
                elements.add(values[i]);
                min = Math.min(min, values[i]);
                max = Math.max(max, values[i]);
                products[i] = (long)(min * max);
            } else {
                elements.remove(values[i]);
                min = elements.first();
                max = elements.last();
                products[i] = (long)(min * max);
            }
        }
        return products;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"push", "push", "push", "pop"};
        int[] values = new int[]{1, 2, 3, 1};
        long[] res = minMax(operations, values);
        for (long i : res)
            System.out.println(i);
    }
}
