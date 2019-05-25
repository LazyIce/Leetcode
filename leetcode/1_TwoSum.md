# Two Sum

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

## Solution

Since there is ***exactly*** one solution, we don't need to worry about the duplicate elements.

### 1. One Pass Hashmap

For two sum, We can keep a hashmap which stores the numbers in array as keys and their positions as values. Then we can solve this problem in one pass.

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(N)
 */
public int[] twoSum(int[] nums, int target) {
	int[] res = new int[]{-1, -1};
	if (nums == null || nums.length < 2) {
	    return res;
	}

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{map.get(target - nums[i]), i};
        }
        map.put(nums[i], i);
    }

    return res;
}
```

### 2. Two Pointers

Here, since the array **isn't sorted** and we need to return the **indices** as the answers, we cannot use **Two Pointers**. 



