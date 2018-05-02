/*
Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3

Example 2:

Input: dividend = 7, divisor = -3
Output: -2

Note:

    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*/

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend<<1 == 0 && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend > 0) ^ (divisor > 0);
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        return divideLong(d1, d2, sign);
    }
    public int divideLong(long dividend, long divisor, boolean sign) {       
        long res = 0;
        while (dividend >= divisor) {
            long multiple = 1;
            long temp_divisor = divisor;
            while (dividend >= (temp_divisor << 1)) {
                temp_divisor <<= 1;
                multiple <<= 1;
            }
            dividend -= temp_divisor;
            res += multiple;
        }
        return sign ? (int) -res : (int) res; 
    }
}