/*
Plus One

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
Java
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            int current = digits[i] + carry;
            if (current >= 10) {
                carry = current / 10;
                current %= 10;
            } else {
                carry = 0;
            }
            digits[i] = current;
        }
        if (carry > 0) {
            int[] re = new int[digits.length + 1];
            re[0] = carry;
            for (int i = 1; i < re.length; i++ ) {
                re[i] = digits[i-1];
            }
            return re;
        } else {
           return digits; 
        }

    }            
}