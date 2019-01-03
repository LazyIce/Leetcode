import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        if(s.length() == 0) return res;

        List<String> list = new ArrayList<String>();
        helper(s, 0, list);
        return res;
    }

    private void helper(String s, int index, List<String> list) {
        //base case
        if(index == s.length()) {
            res.add(new ArrayList(list));
            return;
        }

        for(int len = 1; len + index <= s.length(); len++) {
            String sub = s.substring(index, index+len);
            if(!isValid(sub))
                continue;         //the difference with IP problem

            list.add(sub);       //choose
            helper(s, index+len, list);      //explore
            list.remove(list.size() - 1);    //unchoose
        }
    }

    private boolean isValid(String string) {
        if(string.length() == 0)
            return true;
        int n = string.length();

        int i = 0, j = n-1;
        while(i <= j) {
            if(string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // DP method
    public  List<List<String>> partition2(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
