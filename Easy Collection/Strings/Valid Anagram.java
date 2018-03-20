/*
Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

//Cheat way.
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        String news = new String(charS);
 
        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        String newt = new String(charT); 
        
        return news.equals(newt);
    }
}

//(Hash Table) Array version. 26 Char Table Count
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}