# Instructions

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

* You may assume no duplicates in the array.

> Example 1:

Input: [1,3,5,6], 5
Output: 2

> Example 2:

Input: [1,3,5,6], 2
Output: 1

> Example 3:

Input: [1,3,5,6], 7
Output: 4

>Example 4:
Input: [1,3,5,6], 0
Output: 0
***

# Solution 
``` java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return binarySearch(nums, left, right, target);
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else 
                left = mid + 1;
        }
        return left;
    }
}
```

***
# Thought process

* I learned about using the shift operator
* use binary search to find the middle element and compare to our target for each iteration until loop breaks

    


