import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _824_GoatLatin {
    /**
     * time: O(n)
     * space: O(n)
     */
    public String toGoatLatin(String S) {
        List<Character> list = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        String arr[] = S.split(" ");
        String a="a", test = "";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            test = arr[i];

            if (list.contains(test.charAt(0))) {
                sb.append(test + "ma");
            }
            else {
                sb.append(test.substring(1) + test.charAt(0) + "ma");
            }

            sb.append(a);
            a += "a";
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
