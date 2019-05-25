# Reverse Integer

## Description

Given a 32-bit signed integer, reverse digits of an integer.

## Solution

Here, think about corner case: out of bound. So we need use a long type to keep result.

Note: In Java, for a mod b, the result is ```(sign of a)*|a|%|b|```

```java
/**
 * time complexity: O(logx)
 * sapce complexity: O(1)
 */
public int reverse(int x) {
    long res = 0;
    while (x != 0) {
        res = res * 10 + x % 10;
        x = x / 10;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
    }
    return (int)res;
}
```





