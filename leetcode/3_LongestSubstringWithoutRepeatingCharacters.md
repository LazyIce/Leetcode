# Longest Substring Without Repeating Characters

## Description

Given a string, find the length of the **longest substring** without repeating characters.

## Solution

### Sliding Window

We can keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. Move the right pointer to scan through the string, and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. This is called Sliding Window. Note both pointers can move back.

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(N)
 */
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
        return 0;

    Map<Character, Integer> map = new HashMap<>();
    int j = 0, maxLen = 0;

    for (int i = 0; i < s.length(); i++) {   // Move right pointer
        char cur = s.charAt(i);
        if (map.containsKey(cur)) {
            maxLen = Math.max(i - j, maxLen);
            j = Math.max(j, map.get(cur) + 1);   // Move left pointer.
        }
        map.put(cur, i);
    }
    return Math.max(s.length() - j, maxLen);
}
```





