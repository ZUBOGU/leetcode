/*
Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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

// Could do recursive and have a global variable count
// Iterative, use stack
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null) {
        	s.push(root);
        	root = root.left;
        }
        int count = 0
        while (count < k) {
        	TreeNode curr = s.pop();
        	count++;
        	if (count == k) return curr.val;
        	TreeNode next = curr.right;
        	while (next != null) {
        		s.push(next);
        		next = next.left;
        	}
        }
        return -1 // if k invalid
    }
}