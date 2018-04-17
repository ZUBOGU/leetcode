/*
Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
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

// Modify from Binary Tree Level Order Traversal problem
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrder(root, 0)
    }	

    public List<List<Integer>> zigzagLevelOrder(TreeNode root, int level) {
    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;
    	Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
        	int size = q.size();
        	LinkedList<Integer> cur = new LinkedList<Integer>();
        	for(int i=0; i < size; i++) {
        		if(q.peek().left != null) q.offer(q.peek().left);
        		if(q.peek().right != null) q.offer(q.peek().right);
        		cur.add(q.poll().val);
        	}
        	ret.add(cur);
        }
        return ret;
        
    }
}