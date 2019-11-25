/* Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5 */
class Solution {
    public int lengthOfLastWord(String input) {
        if (input.length() == 0 || input == null ) return 0;
        String trimmed = input.trim();
        int startLastWord = trimmed.lastIndexOf(' ') + 1;
        int lastWordLength = trimmed.length() - startLastWord;
        return lastWordLength;
    }
}

/* 
Thought process

check valid input
trim the input and store it 
find the start of the last word
get the length of the lastword by finding the difference between the length of the string and the index of startLastWord
 */