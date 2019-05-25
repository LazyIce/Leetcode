# Integer to Roman

## Description

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
Chante Integer by Roman numbers.

## Solution

Consider the special format 4, 9, 40, 90, 400 and 900. 

Then the roman format of an integer number is just joining the roman numbers together.

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(N)
 */
public String intToRoman(int num) {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder res = new StringBuilder();
    
    for (int i = 0; i < values.length; i++) {
        while (num >= values[i]) {
            res.append(strs[i]);
            num -= values[i];
        }
    }
    
    return res.toString();
}
```





