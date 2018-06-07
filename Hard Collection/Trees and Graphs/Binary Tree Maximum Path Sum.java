/* Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 

The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxV;
    public int maxPathSum(TreeNode root) {
        maxV = Integer.MIN_VALUE;
        maxPathRecursive(root);
        return maxV;
    }

    int maxPathRecursive(TreeNode root) {
        if (root == null)  return 0;
        // find the max sum from left. That will be one path up to left root
        int left = Math.max(0, maxPathRecursive(root.left));
        // find the max sum from right. That will be one path up to right root
        int right = Math.max(0, maxPathRecursive(root.right));

        // So, for current root, we are calcualting the max without going up and update maxV.
        maxV = Math.max(maxV, left + right + root.val);

        // We are returning one path up to root. Pick the max value from left and right.
        return Math.max(left, right) + root.val;
    }
}