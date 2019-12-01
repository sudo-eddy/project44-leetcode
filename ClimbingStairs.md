# Instructions

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

> Note: Given n will be a positive integer.

> Example 1:
```
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

> Example 2:
```
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

# Solution 

``` java
class Solution {
    public int climbStairs(int n) {
        
        if (n < 2) {
            return n;
        }
        
        int fibX = 1; 
        int fibY = 1;
        int sum = 0;
        
        for (int i = 2; i <= n; i++ ) {
            sum = fibX + fibY;
            fibX = fibY;
            fibY = sum;
        }
        return sum;
    }
}
```
***
# Solution - see it in action
``` java
class Solution {
    public int climbStairs(int n) {
        
        if (n < 2) {
            return n;
        }
        
        int fibX = 1; 
        int fibY = 1;
        int sum = 0;
        
        for (int i = 2; i <= n; i++ ) {
            System.out.println("This is i --> " + i + " ");
            System.out.println("This is fibX --> " + fibX + " ");
            System.out.println("This is fibY --> " + fibY + " ");
            sum = fibX + fibY;
            System.out.println("This is sum --> " + sum + " ");
            fibX = fibY;
            System.out.println("This is fibX --> " + fibX + " ");
            fibY = sum;
            System.out.println("This is new fibY --> " + fibY + " ");
        }
        return sum;
    }
}

```
***
# Thought process

* Basically a fibonacci sequence starting at number 2 anything less than two is a base case so we return n
* avoiding recursion by using fibY as a temp variable at the end of each iteration until the loop reaches value of n */ 


