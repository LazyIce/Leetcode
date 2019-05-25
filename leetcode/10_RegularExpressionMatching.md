# Regular Expression Matching

## Description

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

- s could be empty and contains only lowercase letters a-z.
- p could be empty and contains only lowercase letters a-z, and characters like . or *.

## Solution

**subproblem:** boolean dp[i][j]: whether s[0,i] matches p[0,j]

1. s is empty string

2. If p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]

3. If p.charAt(j) == ‘.’ : dp[i][j] = dp[i-1][j-1];

4. If p.charAt(j) == ‘*’:

- if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //a* only counts as empty

- if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == ‘.’:
  - dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
  - dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
  - dp[i][j] = dp[i][j-2] // in this case, a* counts as empty

```java
/**
 * time complexity: O(M*N)
 * sapce complexity: O(M*N)
 */
public boolean isMatch(String s, String p) {
    if (s == null && p == null)
        return true;
    
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];   // consider empty string, so length+1.
    dp[0][0] = true;
    
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true;
        }
    }
    
    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == s.charAt(i)) {
                dp[i + 1][j + 1] = dp[i][j];
            }
            if (p.charAt(j) == '.') {
                dp[i + 1][j + 1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                } else {
                    dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                }
            }
        }
    }
    
    return dp[s.length()][p.length()];
}
```





