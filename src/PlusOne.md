# Instructions

* Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
* The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

> You may assume the integer does not contain any leading zero, except the number 0 itself.

>Example 1:
```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```
>Example 2:

```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```
***

# Solution
``` java
class Solution {
    public int[] plusOne(int[] input) {
        for (int i = input.length-1; i >= 0; i--) {
            if(i == 0 && input[i] == 9) {
                int[] nineCase = new int[input.length + 1];
                nineCase[0] = 1;
                return nineCase;
            }
            else if (input[i] != 9) {
                input[i] += 1;
                return input;
            } else {
                input[i] = 0;
            }  
        }
        return input;
    }
}
```
***
# Thought process

* check valid input length
* traverse input array from right to left
    * if loop gets to index 0 and it equals 9
        * create a new array that holds one more element than input, change first element to 1 and return it
        * this is special case for 9           
        * it covers inputs like 9,9,9 or 9
    * else if element at input[i] is not 9 add 1 and return
     if it is 9, chance input[i] in place
* repeat until loop ends and return input



