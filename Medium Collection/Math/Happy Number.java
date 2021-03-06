/*Happy Number

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        // Use fast and slow find the cycle if it has
        while (slow != 1) {
            slow = calculate(slow);
            if (slow == 1) return true;
            fast = calculate(calculate(fast));
            if (fast == 1) return true;
            if (slow == fast) break;
        }
        return slow == 1;
    }
    
    int calculate(int n) {
        int ret = 0;
        while (n > 0) {
            ret += (n%10) * (n%10);
            n /= 10;
        }
        return ret;
    }
}