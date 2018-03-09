/*
Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 
*/
class Solution {
    public int reverse(int x) {
        int  sign = 1;
        if ( x < 0) sign = -1;
        x = Math.abs(x);
        long r = 0;
        int curr = 0;
        while (x != 0) {
            curr = x % 10;
            r *= 10;
            r += curr;
            if(r > Integer.MAX_VALUE) return 0;
            if(r < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        r = sign * r;
        return (int) r;
    }
}