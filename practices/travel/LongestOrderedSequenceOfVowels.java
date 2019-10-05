import java.util.Arrays;

public class LongestOrderedSequenceOfVowels {
    public static void main(String[] args) {
        String s = "aeiaaioooauuaeiou";
        char[] c = new char[] {'a', 'e', 'i', 'o', 'u'};

        System.out.println(longestSubsequence(s, c));
    }

    public static int longestSubsequence(String s, char[] c) {
        if(s.length() ==0 || c.length ==0){
            return 0;
        }

        if(s.length() < c.length){
            return -1;
        }

        if(s.length() == c.length){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) !=c [i]){
                    return -1;
                }
            }
            return s.length();
        }

        if(s.charAt(0) < c[0]){
            // ignore, go ahead with next item
            return longestSubsequence(s.substring(1), c);
        } else if (s.charAt(0) == c[0]){
            // <case 1> include item and start search for next item in chars
            // <case 2> include but search for same item again in chars
            // <case 3> don't include item

            return Math.max(
                    Math.max(  ( 1+longestSubsequence(s.substring(1), Arrays.copyOfRange(c, 1, c.length) ) ),
                            ( 1+longestSubsequence(s.substring(1), c ) ) ),
                    ( longestSubsequence(s.substring(1), c )) );
        } else {
            //ignore
            return longestSubsequence(s.substring(1), c);
        }
    }
}
