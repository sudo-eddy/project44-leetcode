# Instructions

The count-and-say sequence is the sequence of integers with the first five terms as following:
```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```
* 1 is read off as "one 1" or 11.
* 11 is read off as "two 1s" or 21.
* 21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

> Note:

Each term of the sequence of integers will be represented as a string.

> Example 1:
```
Input: 1
Output: "1"
```

> Example 2:

```
Input: 4
Output: "1211"
```
***
# Solution 
``` java
class Solution {
    public String countAndSay(int n) {
        //base cases
        if (n == 1) 
            return "1";
        if (n ==2) 
            return "11";
            
        String myString = "1";
        for (int i = 1; i < n; i ++){
            myString = processString(myString); //make recursive call
        }
        return myString;
    }
    
    private String processString(String sequenceString){
        StringBuilder sequenceBuilder = new StringBuilder();
        char myChar = sequenceString.charAt(0); //get first element of passed string 
        int count = 1;
        for (int j = 1; j < sequenceString.length(); j++){
            if (sequenceString.charAt(j) == myChar){
                count ++;
            }else{
                sequenceBuilder.append(count);
                sequenceBuilder.append(myChar);
                myChar = sequenceString.charAt(j);
                count = 1;   
            }
        }
        sequenceBuilder.append(count);
        sequenceBuilder.append(myChar);
        return sequenceBuilder.toString();
    }
}
```
***
# Thought process

* Recursivetly call processString on myString until loop breaks
* every time the string from the last recusrsion call is passed to processString
* append count and myChar accordingly after comparing myChar to the current char at iteration j 
