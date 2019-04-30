import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        Map<Character,Character> map =
                new HashMap<Character,Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('2','\0');
        map.put('3','\0');
        map.put('4','\0');
        map.put('5','\0');
        map.put('6','9');
        map.put('7','\0');
        map.put('8','8');
        map.put('9','6');

        int lo=0;
        int hi=num.length()-1;


        while(lo<=hi){
            if(num.charAt(lo)!=map.get(num.charAt(hi)))
                return false;

            lo++;
            hi--;
        }

        return true;
    }
}
