/*
Power of Three

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

//recursion
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
    	if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}
// Math. Take log both side. If n = 3 ^ i, then i = log3(n);
class Solution {
    public boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

// Integer Limitations
// Therefore, the possible values of n where we should return true are 3^0 3^1 ...3 ^ 19​​. Since 3 is a prime number, the only divisors of 3 ^ 19 are 3^0 3^1 ...3 ^ 19​​.
// Therefore all we need to do is divide 3^19 by n. A remainder of 0 means n is a divisor of 3^19​​ and therefore a power of three.
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}