/*
Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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

//Use preoder to find root, inoder to separete the left and right
// Use a map for inorder list can speed up
// Use recursive call
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	for (int i = 0; i < inorder.length; i++) {
    		hm.put(inorder[i], i);
    	}
    	return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hm) {
    	if (preStart > preEnd || inStart > inEnd) return null;
    	int val = preorder[preStart];
    	TreeNode root = new TreeNode(val);
    	int rootInIn = hm.get(val);
    	int leftCount = rootInIn - inStart;
    	root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftCount, inorder, inStart, rootInIn - 1, hm);
    	root.right = buildTreeHelper(preorder, preStart + leftCount + 1, preEnd, inorder, rootInIn + 1, inEnd, hm);
    	return root;
    }
}