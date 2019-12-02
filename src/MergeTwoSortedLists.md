# Instructions

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

> Example:

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```
> Definition for singly-linked list.
 ``` java
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
```
***
# Solution 
``` java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode myList = new ListNode(0);
    ListNode tempList = myList;
    
    while(l1 != null && l2 != null) {
        if(l1.val > l2.val) {
            tempList.next = l2;
            l2 = l2.next;
        } else {
            tempList.next = l1;
            l1 = l1.next;
        }
        tempList = tempList.next;
    }
    
    if(l1 == null) {
        tempList.next = l2;
    } else {
        tempList.next = l1;
    }
    
    return myList.next;

    }
}
```

***
# Thought process

* Make a new list, compare input lists values and add them to tempList accordingly
* when input lists are empty, loop breaks and returns myList.
