/*
Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Binary tree [2,1,3], return true.

Example 2:

    1
   / \
  2   3

Binary tree [1,2,3], return false. 
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
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
    	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);     
    }

    public boolean isValidBST(TreeNode root, long Min, long Max) {
    	if (root == null) return true;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	int val = root.val;
    	if (Min >= val) {
    		return false;
    	}
    	if (Max <= val) {
    		return false;
    	}

    	if (left != null) {
    		if (val <= left.val) {
    			return false;
    		}
    	}
    	if (right != null) {
    		if (val >= right.val) {
    			return false;
    		}
    	}
    	return isValidBST(left, Min, (long) val) && isValidBST(right, (long) val, Max);     
    }
}