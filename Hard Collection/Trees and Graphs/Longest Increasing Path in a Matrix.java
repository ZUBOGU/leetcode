/* Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 

You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */

 // DFS 
 class Solution {
  int[][] memo;
  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    memo = new int[m][n];

    int maxV = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int val = dfs(matrix, i, j, m, n, Integer.MAX_VALUE);
        maxV = Math.max(maxV, memo[i][j]);
      }
    }
    return maxV;
  }

  int dfs(int[][] matrix, int i, int j, int m, int n, int pre) {
    //base case out scope. return 0;
    if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] >= pre) return 0;
    if (memo[i][j] > 0) {
      return memo[i][j];
    } else {
      int cur = matrix[i][j];
      int maxV = 0;
      maxV = Math.max(maxV, dfs(matrix, i-1, j, m, n, cur));
      maxV = Math.max(maxV, dfs(matrix, i+1, j, m, n, cur));
      maxV = Math.max(maxV, dfs(matrix, i, j-1, m, n, cur));
      maxV = Math.max(maxV, dfs(matrix, i, j+1, m, n, cur));
      memo[i][j] =  ++maxV;
      return maxV;
    }
  }
}