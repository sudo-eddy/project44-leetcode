import java.util.*;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
exactly one solution, and you may not use the same element twice.

Example:    
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Thought process

create a hashMap to store a key and value 
traverse through the array and doing the following for each iteration:

subtract the current value of i from target and store it in difference
hold the current value and index of i in storeDifference
if storeDifference's stored value is equal to the current value of difference for this iteration we have found a match
and can return result as
result[0] -the key of difference stored in storeDifference
result[1] -the index of the current value of i in which the condition was met
else keep looping through the array and storing the current iteration value in storeDifference until condition is met
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> storeDifference = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(storeDifference.containsKey(difference)) {
                result[0] = storeDifference.get(difference);
                result[1] = i;
                return result;
            }
            storeDifference.put(nums[i], i);
        }
        throw new IllegalArgumentException("No match");
    }
}
