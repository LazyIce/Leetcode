import java.util.List;
import java.util.ArrayList;

public class _412_FizzBuzz {
    /**
     * time: O(n)
     * space: O(1)
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1,fizz = 0,buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz=0;
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
