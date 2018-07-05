/* Word Break II

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<Integer, List<String>>(), 0);
    }

    //Backtracking by current position.
    public List<String> helper(String s, List<String> wordDict, HashMap<Integer, List<String>> map, int cur) {
        if(map.containsKey(cur)) return map.get(cur);
        List<String> res = new ArrayList<String>();
        if (cur == s.length()) {
            res.add("");
            return res;
        }
        for (String word: wordDict) {
            if (s.startsWith(word, cur)) {
                List<String> next = helper(s, wordDict, map, cur+word.length());
                for(String nString : next) {
                    res.add(word+(nString.length() == 0 ? "":" ")+nString);
                }
            }
        }
        map.put(cur, res);
        return res;
    }
}