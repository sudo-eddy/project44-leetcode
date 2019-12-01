/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. */
class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return maxSubArraySum(nums, left, right);
    }
    private int maxCrossingSum(int[] nums, int left, int mid, int right) { 
        //sum for elements to the left of mid
        int sum = 0; 
        int leftSum = Integer.MIN_VALUE;
        
        for (int i = mid; i >= left; i--) { 
            sum += nums[i];    
            if (sum > leftSum) {
                leftSum = sum;
            }
        } 
  
        //sum of elements to the right of mid 
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        
        for (int j = mid + 1; j <= right; j++) { 
            sum += nums[j]; 
            if (sum > rightSum) {
            rightSum = sum;
            }
        } 
  
        //sum of crossing
        return leftSum + rightSum; 
    } 
  
    // Returns sum of maxium sum subarray  
    private int maxSubArraySum(int nums[], int left, int right) { 
    
        //Base Case: Only one element 
        if (left == right) {
            return nums[left];
        }
    
        // Find mid 
        int mid = (left + right) >> 1;
     
        int leftSubArraySum = maxSubArraySum(nums, left, mid);
        int rightSubArraySum = maxSubArraySum(nums, mid + 1, right);
        int crossingSum = maxCrossingSum(nums, left, mid, right);

        //determine max of all three sums
        return Math.max(Math.max(leftSubArraySum, rightSubArraySum), crossingSum);
    }     
}

/* Thought process 

Divide left and right of array
call binarySearch recursively until we run out of elements in the array to turn into left and right subarrays
determine max between left and right and crossingr */