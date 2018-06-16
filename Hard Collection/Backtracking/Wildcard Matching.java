/* Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */

class Solution {
    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0, match = 0, starIndex = -1;
        while ( sPtr < s.length()) {
            char sCh = s.charAt(sPtr);

            // mathc move both pointers.
            if (pPtr < p.length() && (p.charAt(pPtr) == '?' || p.charAt(pPtr) == sCh)) {
                sPtr++;
                pPtr++;
            // found *. increase pPtr. Not moving sPtr.
            // After this part, we keep checking  later sCh & pCh.
            // if sCh & pCh not match at some point, if will go to next condition
            } else if (pPtr < p.length() &&  p.charAt(pPtr) == '*') {
                starIndex = pPtr;
                match = sPtr;
                pPtr++;
            // sCh & pCh not match, pch is not '?' or '*' at this time.
            // But we have last pattern is '*'.
            } else if (starIndex != -1) {
                //move back the pPtr to last '*' pattern.
                pPtr = starIndex + 1;

                // Match one char from s for '*' and continue the checking
                match++;
                sPtr = match;
            } else {
                return false;
            }
        }

        // Check the rest ptr of p
        while (pPtr < p.length() && p.charAt(pPtr) == '*') {
            pPtr++;
        }

        return pPtr == p.length();
    }
}