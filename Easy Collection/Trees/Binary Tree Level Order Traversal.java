/*
Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
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

//BFS loop each level
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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