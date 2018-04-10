/*
Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

 

Example:

Input: "cbbd"

Output: "bb"

*/

// Solve as a DP problem O(n^2) time and space
// to solve space complexity, expand around center. there is 2n -1 center. Could be 1 or 2 chars as center.
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) 
            {
            	start = i - (len - 1) / 2;
            	end = i + len / 2;
            }
        }
        return s.equals("") ? "" : s.substring(start, end + 1);
    }

    int expand(String s, int l, int r) {
    	while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    		l--;
    		r++;
    	}
    	return r - l - 1;
    }
}