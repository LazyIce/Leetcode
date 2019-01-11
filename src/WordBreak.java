import java.util.List;

public class WordBreak {
    /**
     *
     * time: O(n^3)
     * space: O(n)
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[s.length()];
    }

    /**
     *
     * time: O(n^3)
     * space: O(n)
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
