# Add Two Numbers

## Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Solution

Here, we need to consider the carry. Also, we should consider that the length of two linked lists may be different.

```java
/**
 * time complexity: O(N)
 * sapce complexity: O(N)
 */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode result = new ListNode(0);   // keep the head of result
    ListNode pointer = result;   // link each digit
    
    // traverse two linked lists
    while (l1 != null || l2 != null) {
        int n1 = 0, n2 = 0;
        if (l1 != null) {
            n1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
        }
        int temp = n1 + n2 + carry;
        carry = temp / 10;
        temp = temp % 10;
        pointer.next = new ListNode(temp);
        pointer = pointer.next;
    }
    
    // add the last carry if it exists 
    if (carry > 0) {
        pointer.next = new ListNode(carry);
    }
    
    return result.next;
}
```



