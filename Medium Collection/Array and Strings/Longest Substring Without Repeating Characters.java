/*
Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	char[] arr = s.toCharArray();
    	int max = 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	// check two pointer
    	// move the left pointer i to one right of the dupl char if find dupl
    	for (int i = 0, j = 0; j < arr.length; j++) {
    		if (map.containsKey(arr[j])) {
    		    i = Math.max(map.get(arr[j]) + 1, i);
    		}
    		max = Math.max(max, j - i + 1);
    		map.put(arr[j], j);
    	}
    	return max;
    }
}