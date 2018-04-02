/*
Count and Say
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n-1);
        return say(prev);
    }
    
    public String say(String s) {
        int cur = 0;
        int prev = 0;
        int count = 0;
        String ret = "";
        for (int i = 0; i < s.length(); i ++) {
        	cur = s.charAt(i) - '0';
        	if (prev == 0 ) {
                prev = cur;
        		count += 1;
        	} else if (cur == prev) {
                count += 1;
            } else {
            	ret += count;
        		ret += prev;
    			prev = cur;
    			count = 1;
        	}
        }
        //say last part
        ret += count;
        ret += cur;
        return ret;
    }
}
}