/*
First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/
class Solution {
    public int firstUniqChar(String s) {
        int ret = -1;
        if (s == null || s.equals("")) {
            return ret;
        }

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i =0; i < s.length(); i++) {
        	if (hm.containsKey(s.charAt(i))) {
        		hm.put(s.charAt(i), -i); //invalid this char;
        	} else {
        		hm.put(s.charAt(i), i);
        	}
        }
        
        ret = Collections.max(hm.values());
        if (ret < 0) return -1;
        for (int j : hm.values()) {
        	if (j >= 0) {
        		ret = Math.min(j, ret);
        	}
        }
        return ret;
    }
}