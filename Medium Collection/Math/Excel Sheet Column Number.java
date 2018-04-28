/*
Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701
*/

class Solution {
    public int titleToNumber(String s) {
        char[] arrayS = s.toCharArray();
        int length = arrayS.length;
        int sum = 0;
        for (int i = 0 ; i < length; i++) {
            int value = (int) arrayS[i] - 64;
            sum += value * Math.pow(26, length - i - 1); 
        }
        return sum;
    }
}