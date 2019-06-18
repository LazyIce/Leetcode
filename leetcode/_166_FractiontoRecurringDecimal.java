import java.util.Map;
import java.util.HashMap;

public class _166_FractiontoRecurringDecimal {
    /**
     * time: O(logn)
     * space: O(n)
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 1)
            return String.valueOf(numerator);

        StringBuilder res = new StringBuilder();
        // condier sign "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0) ? "-" : ""));
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        // integer part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            // find the index of start of repeat part, and add ()
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
