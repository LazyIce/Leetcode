# Longest Palindromic Substring

## Description

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

## Solution

### Dynamic Programming
- **subproblem:** ```dp[i][j]``` means whether ```s.substring(i, j+1)``` is palindromic substring
- **transition function:** 
	- ```dp[i][j] = s.charAt(i) == s.charAt(j) if j - i <= 2```
	- ```dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1] if j - 1 > 2```

```java
/**
 * time complexity: O(N^2)
 * sapce complexity: O(N^2)
 */
public String longestPalindrome(String s) {
    if(s.length() == 1)
        return s;
        
    String res = "";
    boolean[][] dp = new boolean[s.length()][s.length()];
    int max = 0;
    
    for (int j = 0; j < s.length(); j++) {
        for (int i = 0; i <= j; i++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i+1][j-1]);
            if (dp[i][j]) {
                if (j - i + 1 > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
    }
    
    return res;
}
```





