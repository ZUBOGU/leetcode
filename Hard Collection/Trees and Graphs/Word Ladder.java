/* Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, 
such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        // Covert to hash set to imporve speed. O(1) check if it contains.
        Set<String> wordSet = new HashSet<>();
        for (String str : wordList) {
            wordSet.add(str);
        }

        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // switch for performance. 
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String target = String.valueOf(chars);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            //Only visit one word once
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }
        return 0;
    }
}