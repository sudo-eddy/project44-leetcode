# Instructions

Given a 32-bit signed integer, reverse digits of an integer.

> Example 1:
```
Input: 123
Output: 321
```
> Example 2:
```
Input: -123
Output: -321
```
> Example 3:
```
Input: 120
Output: 21
```

> Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

# Solution 
``` java
class Solution {
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }

        long reversed = 0;
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return negative ? (int) (-1 * reversed) : (int) reversed;
    }
}
```
***
# Thought process

* Check if input is negative and convert to positive
* Store reversed number in a long - to be on the safe side
    * while x is more than zero multiply reversed by 10 and add the result of (x % 10) 
    * divide x/10 and continue looping we are basically adding all results from x % 10 to reverse.
* check if reversed is within Integer boundaries 
* if number was negative from initial check, make it negative again and cast as int 


 > Example run:

```
    input 123
    reversed = 0
        0 * 10 = 0
        +
        123 % 10 = 3
    reversed = 3
    x /= 10 = 12
        3 * 10 = 30
        +
        12 % 10 = 2
    reversed = 32
    x /= 10 = 1
        32 * 10 = 320
        +
        1 % 10 = 1
    reversed = 321
    last iteration breaks loop and returns reversed
```
 
