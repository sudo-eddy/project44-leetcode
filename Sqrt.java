/* Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
the decimal part is truncated, 2 is returned. */

class Solution {
    public int mySqrt(int x) {
        long low = 1,high = x;
        if (x < 2) {
            return x;
        } return binarySearch(low, high, x);
    }
    private int binarySearch(long left, long right, int target) {    
        while(left < right){
            long mid = left + (right - left) / 2;
            long squareMid = mid * mid;
            
            if (squareMid == target) {
                return (int)mid;
            } else if (squareMid < target) {
                left = mid + 1;
            } else right = mid;
        }
        return (int)left - 1;        
    }        
}

/* 
Thought process

use long variables to aviod overflow
x cannot be negative but can be 1 or 0, for this case we just return x
otherwise we assume x is more than 2 and use a binary search to find square root of x
    while left is less than right perform the following for each iteration
    determine mid point
    store mid * mid in squareMid
    if squareMid equals target return mid (and cast to integer)
    **squareMid will never be less than x on the first iteration because of the naure of this square root problem
    assign value of mid + 1 to left and iterate again, best case squareMid == target 
    otherwise loop will break and return left -1 because there's no more numbers to try and match 
*/