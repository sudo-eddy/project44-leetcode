/* Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101" */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }

            i--;
            j--;
            
            sb.append(sum % 2);
            carry = sum >> 1;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        
        String binaryAnswer = sb.reverse().toString();
        return binaryAnswer;
    }
}

/*

Thought process

traverse through strings from the back, we are adding like an addition in paper
it is possible that one string might finish traversing before the other one with the while loop so 
we make sure to check i and j
assign value of carry to sum if there was a carry
subtract '0' to get the int value from ascii 
if sum is 2 or sum is 0 append 0 if sum is 3 append 1 we can determine all of this by sum % 2
update carry, when loop is done, chec for leftover carry and append
reverse sb and get binaryAnswer
 */


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                System.out.println("This is i --> " + a.charAt(i) + " ");
                System.out.println("This is sum --> " + sum + " ");
                
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                System.out.println("This is j --> " + b.charAt(j) + " ");
                System.out.println("This is sum --> " + sum + " ");
            }
            
            i--;
            j--;
            
            
            sb.append(sum % 2);
            System.out.println("This is string so far --> " + sb.toString() + " ");
            carry = sum >> 1;
            System.out.println("This is carry --> " + carry + " ");
        }
        if (carry != 0) {
            sb.append(carry);
            System.out.println("This is string after carry --> " + sb.toString() + " ");
            
        }
        
        String binaryAnswer = sb.reverse().toString();
        System.out.println("sb reversed = answer --> " + binaryAnswer + " ");
        return binaryAnswer;
    }
}