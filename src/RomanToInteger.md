# Instructions

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

* I can be placed before V (5) and X (10) to make 4 and 9. 
* X can be placed before L (50) and C (100) to make 40 and 90. 
* C can be placed before D (500) and M (1000) to make 400 and 900.
* Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

> Example 1:

```
Input: "III"
Output: 3
```
> Example 2:
```
Input: "IV"
Output: 4
```
> Example 3:
```
Input: "IX"
Output: 9
```
> Example 4:
```
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```
> Example 5:
```
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

***
# Solution - HashMap
```java
class Solution {
    public int romanToInt(String input) {
    HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    
        char[] romanChars = input.toCharArray();

        int total = 0;
        int specialRomanTracker = 0;

        for (char romanChar : romanChars) {
            int romanValue = romanMap.get(romanChar);

            if (specialRomanTracker < romanValue) {
                total -= specialRomanTracker;
                romanValue -= specialRomanTracker;
            }

            total += romanValue;
            specialRomanTracker = romanValue;

        }
        romanMap.clear();
        return total;
    }
}
```
***
# Thought process

* put the roman characters and their corresponding values in a hashmap
* declare two parallel sum variables one to keep track of special case roman numerals
* and one to keep track of the actual total
* traverse through array and compare the values
***
# Solution - see it in action

``` java
class Solution {
    public int romanToInt(String input) {
    HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    
        char[] romanChars = input.toCharArray();

        int total = 0;
        int specialRomanTracker = 0;

        for (char romanChar : romanChars) {
            int romanValue = romanMap.get(romanChar);
            System.out.println("This is romanValue --> " + romanValue + " ");
            System.out.println("This is specialRomanTracker --> " + specialRomanTracker + " ");


            if (specialRomanTracker < romanValue) {
                total -= specialRomanTracker;
                romanValue -= specialRomanTracker;
                System.out.println("This is total - special case --> " + romanValue + " ");
                System.out.println("This is romanValue --> " + romanValue + " ");
            }

            total += romanValue;
            System.out.println("This is total --> " + total + " ");
            specialRomanTracker = romanValue;
            System.out.println("***iteration***");

        }
        romanMap.clear();
        return total;
    }
}
```

***



