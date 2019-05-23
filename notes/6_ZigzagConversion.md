# Zigzag Conversion

## Description

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

P &nbsp; &nbsp; &nbsp; &nbsp; A &nbsp; &nbsp; &nbsp; &nbsp; H &nbsp; &nbsp; &nbsp; &nbsp;N

A &nbsp; P &nbsp; &nbsp;L &nbsp; S &nbsp; &nbsp;I &nbsp; &nbsp; I &nbsp; G

Y &nbsp; &nbsp; &nbsp; &nbsp; I &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;R

And then read line by line: "PAHNAPLSIIGYIR"

## Solution

Here, we keep ```numRows``` strings  to keep the characters on each row for the zigzag string. So the key is to find the row index of each character in the original string. 

Here, the zigzag unit repeates every ```2*(numRows-1)``` characters. We can get the unit index of character in the zigzag unit by ```i%(2*(numRows-1))```. Thus the row index of character is just unit index if unit index smaller than ```numRows```. Otherwise, the row index is ```2*(numRows-1)``` minus unit index. (Think about that the unit index is bigger, the row index is smaller in this case.)

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(N)
 */
public String convert(String s, int numRows) {
    if (numRows <= 1)
        return s;
    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i = 0; i < sb.length; i++) {
        sb[i] = new StringBuilder("");
    }
    for (int i = 0; i < s.length(); i++) {
        int index = i % (2 * numRows - 2);
        index = index < numRows ? index : 2 * numRows - 2 - index;
        sb[index].append(s.charAt(i));
    }
    for (int i = 1; i < sb.length; i++) {
        sb[0].append(sb[i]);
    }
    return sb[0].toString();
}
```





