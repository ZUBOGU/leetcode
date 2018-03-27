/*
 Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

*/

class Solution {
    public int strStr(String haystack, String needle) {
    	int l1 = haystack.length(), l2 = needle.length();
    	if (haystack.equals(needle)) {
    		return 0;
    	}
    	int diff = l1 - l2;
    	for (int i = 0; i < diff+1; i++) {
    		if (haystack.substring(i,i+l2).equals(needle)) {
    			return i;
    		}
    	}
    	return -1;        
    }
}