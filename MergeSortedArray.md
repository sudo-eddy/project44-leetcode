# Instructions

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

> Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

>Example:

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```
***

# Solution
``` java
class Solution {
    public void merge(int[] bigArr, int initialBigArrSize, int[] smallArr, int fixedSmallSize) {
        
        int i = initialBigArrSize -1;
        int j = fixedSmallSize - 1;
        int bigSize = initialBigArrSize + fixedSmallSize - 1;
        
        while (i >= 0 && j >= 0) {
            bigArr[bigSize--] = bigArr[i] > smallArr[j] ? bigArr[i--] : smallArr[j--];
        }
        
        while (j >= 0) {
            bigArr[bigSize--] = smallArr[j--];
        }
    }
}
```
***
# Thought process

* there are three array lengths, initial size of the big array, size of the small array, and size of both combined (the actual size of the big array)
* traverse in reverse through both arrays, compare values and assign them to `bigArr[bigSize--]` in place until the loops break.
