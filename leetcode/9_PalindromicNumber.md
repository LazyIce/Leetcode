# Palindromic Number

## Description

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

## Solution

Here, we can reverse the number and compare with the original number.

```java
/**
 * time complexity: O(logx)
 * sapce complexity: O(1)
 */
public boolean isPalindrome(int x) {
    if (x < 0 || x != 0 && x % 10 == 0)
        return false;
    int num = x;
    int reverse = 0;
    while (x != 0) {
        reverse = reverse * 10 + x % 10;
        x /= 10;
    }
    return reverse == num;
}
```





