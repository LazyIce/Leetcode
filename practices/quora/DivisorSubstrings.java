import java.util.HashSet;
import java.util.Set;

public class DivisorSubstrings {
    public static void main(String[] args) {
        int num = 120;
        int k = 2;

        Set<Integer> set = new HashSet<>();
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length() - k + 1; i++) {
            int divisor = Integer.parseInt(numStr.substring(i, i + k));
            if (num % divisor == 0) {
                set.add(divisor);
            }
        }

        System.out.println(set.size());
    }
}
