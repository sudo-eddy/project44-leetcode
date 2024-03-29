# Instructions

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

> Example 1:

Input: "()"
Output: true

>Example 2:

Input: "()[]{}"
Output: true

>Example 3:

Input: "(]"
Output: false

>Example 4:

Input: "([)]"
Output: false

>Example 5:

Input: "{[]}"
Output: true

***
# Solution - Stack

``` java
class Solution {
    public boolean isValid(String userInput) {
        char openParenthesis = '(', openCurly = '{', openBracket = '[';
        char closeParenthesis = ')', closeCurly = '}', closeBracket = ']';
        if (userInput == null || userInput.length() == 0) 
            return true;
        Stack<Character> parenthesisStack = new Stack<>(); 
        for (char bracketType : userInput.toCharArray()) {  
            if (bracketType == openParenthesis || bracketType == openCurly || bracketType == openBracket) { 
                parenthesisStack.push(bracketType); 
            } else if (bracketType == closeParenthesis || bracketType == closeCurly || bracketType == closeBracket) { 
                if (parenthesisStack.isEmpty()) {
                    return false;
                }
                if (bracketType == closeParenthesis && parenthesisStack.peek() == openParenthesis) { 
                    parenthesisStack.pop();
                } else if (bracketType == closeCurly && parenthesisStack.peek() == openCurly) {
                    parenthesisStack.pop();
                } else if (bracketType == closeBracket && parenthesisStack.peek() == openBracket) {
                    parenthesisStack.pop();
                } else {
                    return false;
                }
            }
        }
        return parenthesisStack.isEmpty(); 
    }
}
```
***
# Thought process 

* empty string is valid
* create a new stack because we want to see last in first out (LIFO)
* convert user input into an array of chars and loop through it, for each char bracketType do the following:
    * compare if bracketType is an opener bracketType if true, add to stack (only pushing openers to stack)
    * else if it's a closer and if stack is empty, end loop
    * but if bracketType is a closer and last element is an opener we pop the opener and continue looping to find a match
* when stack empty true means they all matched since we're popping elements in the stack when there's a match
