import java.awt.List;
import java.util.ArrayList;

/* Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 

The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]

Note:
You may assume that all inputs are consist of lowercase letters a-z. */

// Brute force. Very slow.
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        for (String s : words) {
            if (exist(board, s)) {
                // remove dupl res
                if (!res.contains(s)) {
                    res.add(s);
                }
            }
        }
        return res;
    }

    // From word search I. 
    public boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (search(board, y, x, w, 0)) return true;
	    	}
	    }
	    return false;
    }

    private boolean search(char[][] board, int y, int x, char[] word, int index) {
		if (index == word.length) return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length || board[y][x]!= word[index]) return false;
		board[y][x] = '*';
		boolean search = search(board, y, x+1, word, index+1)
			|| search(board, y, x-1, word, index+1)
			|| search(board, y+1, x, word, index+1)
			|| search(board, y-1, x, word, index+1);
		board[y][x] = word[index];
		return search;
	}
}