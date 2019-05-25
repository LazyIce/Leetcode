public class StringToInteger {
    /**
     * time: O(N)
     * space: O(1)
     */
    public int myAtoi(String str) {
        str = str.trim();
        
        if (str == null || str.length() == 0)
            return 0;
    
        long res = 0;
        int sign = 1;
        int start = 0;
        
        char firstChar = str.charAt(0);
        if (firstChar == '+')
            start++;
        else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch))
                return (int) res * sign;
            else {
                res = res * 10 + ch - '0';
                if (sign == 1 && res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (sign == -1 && res - 1 > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        
        return (int) res * sign;
    }
}
