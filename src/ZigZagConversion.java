public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int cycle = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<= cycle/2;i++){
            for(int j = i,k = cycle - j;j<s.length();j += cycle,k+= cycle){
                sb.append(s.charAt(j));
                if(k < s.length() && k % (cycle/2) != 0) sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
}
