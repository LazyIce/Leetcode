# String to Integer

## Description

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT\_MAX (231 − 1) or INT\_MIN (−231) is returned.

## Solution

Corner case:

- the space in the start
- the sign at first character: + if '+' or digit, - if '-'
- INT\_MAX or INT\_MIN

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(1)
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
```





