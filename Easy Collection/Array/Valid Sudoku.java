/*
Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
    	boolean[][] column = new boolean[9][9];
    	boolean[][] block = new boolean[9][9];
    	for (int i = 0; i < 9; i ++) {
    		for (int j = 0; j < 9; j++) {
    			char curr = board[i][j];
    			if (curr == '.') continue; // skip if it is '.'.
    			int index = curr-'1'; // get current board value, -'1' to get index of this value
    			// Find the index value in  row, column, block, it is true, return false as it is dupl
    			if (row[i][index] || column[j][index] || block[(i/3)*3+(j/3)][index]) {
    				return false;
    			}
    			row[i][index] = true;
    			column[j][index] = true;
    			block[(i/3)*3+(j/3)][index] = true;
    		}
    	}
    	return true;
    }
}