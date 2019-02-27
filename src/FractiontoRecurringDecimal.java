import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long r = n % d;

        if(numerator != 0 && numerator > 0 ^ denominator > 0)
            sb.append("-");

        sb.append(n / d);                       // Integral part

        if(r > 0)
            sb.append(".");						// Fractional part

        while(r > 0) {
            if(map.containsKey(r)) {
                int index = map.get(r);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(r, sb.length());
                r = r * 10;
                sb.append(r / d);
                r = r % d;
            }
        }
        return sb.toString();
    }
}
