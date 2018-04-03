/*
Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.
Follow up:

Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j ++) {
        		if (matrix[i][j] == 0) {
        			//mark first row at index i = 0;
        			matrix[i][0] = 0;
        			//mark first column at index j = 0;3
        			matrix[0][j] = 0;

        			// mark firstRow, firstCol if needed
        			if (i == 0) firstRow = true;
        			if (j == 0) firstCol = true;
        		}
        	}
        }

        // loop first col, if any index == 0, mark whole row to 0
        for (int i = 1; i < m; i ++) {
        	for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
        	}
        }


        // check first row and col
        if (firstCol) {
        	for (int i = 0; i < m; i++) {
        		matrix[i][0] = 0;
        	}
        }

        if (firstRow) {
        	for (int j = 0; j < n; j++) {
        		matrix[0][j] = 0;
        	}
        }
        
    }
}