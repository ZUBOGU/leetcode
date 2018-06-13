import java.awt.List;
import java.util.ArrayList;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

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

// Backtracking and Trie
/* The following picture explains construction of trie using keys given in the example below,

                       root
                    /   \    \
                    t   a     b
                    |   |     |
                    h   n     y
                    |   |  \  |
                    e   s  y  e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r */

class Solution {
    class TrieNode {
        TrieNode[] links;
        boolean isEnd;
        String word;
        public TrieNode() {
            links = new TrieNode[26];
            isEnd = false;
            word = null;
        }
    }

    class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.links[ch - 'a'] == null) {
                    node.links[ch - 'a'] = new TrieNode();
                }
                node = node.links[ch - 'a'];
            }
            node.isEnd = true;
            node.word = word;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<String>();
        // Fast failure
        if (words == null || words.length == 0 || board == null || board.length == 0) return res;

        // Build the Trie tree
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i]);
        }
        
        // So just one loop all char on board instal words.length as the brute force one. Speed up
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                dfs(board, y, x, res, t.root);
            }
        }
        return res;
    }

    // dfs search
    private void dfs(char[][] board, int y, int x, List<String> res, TrieNode p) {
        // Out of bound, just return.
        if (y<0 || x<0 || y == board.length || x == board[y].length) return;
        // Base case
        char c = board[y][x];
        // visited before or not matching
        if ( c == '*' || p.links[c - 'a'] == null) return;
        p = p.links[c - 'a'];
        if (p.word != null && p.isEnd) {
            res.add(p.word);
            p.word = null; //avoid duplicate checking trie.
        }
        // avoid use twice when search world.
        board[y][x] = '*';
        dfs(board, y, x+1, res, p);
        dfs(board, y, x-1, res, p);
        dfs(board, y+1, x, res, p);
        dfs(board, y-1, x, res, p);
        board[y][x] = c;
    }
}

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