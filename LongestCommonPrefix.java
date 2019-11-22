/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/
class Solution {
    public String longestCommonPrefix(String[] input) {
        if(input == null || input.length == 0)
            return "";
        String prefix = input[0];
        for (int i = 1; i < input.length; i++){
            while(input[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) 
                    return "";
            }
        }
        return prefix;
    }
}
/*
Thought process

Check if input is null or length 0
Store the first word of input in prefix
start looping at index 1 while index of prefix is not zero
get the substring of prefix and return it

*/