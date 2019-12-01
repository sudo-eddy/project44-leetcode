# Instructions
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

> Example 1:

```
Input: 121
Output: true
```
> Example 2:
```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```
> Example 3:

```
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```
> Follow up:

Coud you solve it without converting the integer to a string?
***

# Solution -
``` java
class Solution {
    public boolean isPalindrome(int inputNumber) {
        boolean trailingZero = false;
        if (inputNumber % 10 == 0)
            trailingZero = true;
        if (inputNumber < 0 || (inputNumber != 0 && trailingZero))
            return false;
        
        int halfReversed = 0;
        while (inputNumber > halfReversed) {
            halfReversed = halfReversed * 10 + inputNumber % 10;
            inputNumber /= 10;
        }
        return halfReversed == inputNumber || halfReversed / 10 == inputNumber;
    }
}
```
***
# Thought process

* Avoid confusion by storing trailingZero checker in boolean
* return false if number is negative, if number is not zero and has trailing zero
* when number is less than halfReversed the loop breaks
   *  compare halfreversed to number
   *  when number is odd lenght we compare halfReversed / 10 to number (we are comparing to the value of number at the end of loop not the initial value)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   