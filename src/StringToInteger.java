public class StringToInteger {
    public int myAtoi(String str) {
        double res = 0;
        boolean negative = false;
        String newStr = str.trim();
        if (newStr.length() == 0)
            return (int)res;
        if (newStr.charAt(0) != '-' && newStr.charAt(0) != '+' && !Character.isDigit(newStr.charAt(0)))
            return (int)res;
        if (newStr.charAt(0) == '-')
            negative = true;
        if (Character.isDigit(newStr.charAt(0)))
            res += newStr.charAt(0) - '0';
        for (int i = 1; i < newStr.length(); i++) {
            if (!Character.isDigit(newStr.charAt(i)))
                break;
            else {
                res = res * 10 + (newStr.charAt(i) - '0');
            }
        }
        if (negative) {
            res = res * (-1);
        }
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)res;
    }
}
