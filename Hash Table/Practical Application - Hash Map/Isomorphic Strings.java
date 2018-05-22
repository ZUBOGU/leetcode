/* Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length. */

public class Solution {
    
    //without using map
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

// Hash Map
//     public boolean isIsomorphic(String s, String t) {
//         if (s == null || t == null) return false;
//         if (s.length() != t.length()) return false;

//         Map<Character, Integer> mapS = new HashMap<Character, Integer>();
//         Map<Character, Integer> mapT = new HashMap<Character, Integer>();

//         for (int i = 0; i < s.length(); i++) {
//             int indexS = mapS.getOrDefault(s.charAt(i), -1);
//             int indexT = mapT.getOrDefault(t.charAt(i), -1);

//             if (indexS != indexT) {
//                 return false;
//             }

//             mapS.put(s.charAt(i), i);
//             mapT.put(t.charAt(i), i);
//         }

//         return true;
//     }

}